package com.example.danpfinalassignment.ui.screens

import android.content.Context
import android.os.Build
import android.util.Base64
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.danpfinalassignment.aws.Secrets
import org.eclipse.paho.client.mqttv3.*
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.KeyStore
import java.security.PrivateKey
import java.security.cert.CertificateFactory
import java.security.spec.PKCS8EncodedKeySpec
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManagerFactory

class MqttBroker(private val brokerUrl: String, private val clientId: String, private val context: Context)  {

    private lateinit var client: MqttClient

    @RequiresApi(Build.VERSION_CODES.O)
    fun connect() {
        val persistence = MemoryPersistence()
        client = MqttClient(brokerUrl, clientId, persistence)

        val options = MqttConnectOptions()
        options.isCleanSession = true
        options.socketFactory = SslUtil.createSSLSocketFactory(context)

        client.connect(options)

        client.setCallback(object : MqttCallback {
            override fun connectionLost(cause: Throwable?) {
                Log.i("INFO","Connection lost: ${cause?.message}")
            }

            override fun messageArrived(topic: String?, message: MqttMessage?) {
                Log.i("INFO","Message received on topic: $topic - ${message?.payloadToString()}")
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                Log.i("INFO","Message delivered")
            }
        })
    }

    fun publish(topic: String, message: String) {
        val mqttMessage = MqttMessage(message.toByteArray(StandardCharsets.UTF_8))
        client.publish(topic, mqttMessage)
    }

    fun subscribe(topic: String, onMessageReceived: (String) -> Unit) {
        client.subscribe(topic) { _, message ->
            val receivedMessage = String(message.payload)
            onMessageReceived(receivedMessage)
        }
    }

    fun disconnect() {
        client.disconnect()
    }
}

private fun MqttMessage?.payloadToString(): String {
    return this?.payload?.toString(StandardCharsets.UTF_8) ?: ""
}

object SslUtil {
    @RequiresApi(Build.VERSION_CODES.O)
    fun createSSLSocketFactory(context: Context): SSLSocketFactory {
        val password = "".toCharArray()

        val secrets = Secrets() // Instancia de la clase Secrets que contiene las claves

        // Decodificar el certificado del cliente desde la cadena
        val clientCertificateBytes = Base64.decode(secrets.certificate, Base64.DEFAULT)

        // Decodificar la clave privada desde la cadena
        val privateKeyBytes = Base64.decode(secrets.private_Key, Base64.DEFAULT)

        // Crear el certificado del cliente
        val clientCertificateFactory = CertificateFactory.getInstance("X.509")
        val clientCertificate = clientCertificateFactory.generateCertificate(ByteArrayInputStream(clientCertificateBytes))

        // Cargar la clave privada
        val keySpec = PKCS8EncodedKeySpec(privateKeyBytes)
        val keyFactory = KeyFactory.getInstance("RSA")
        val privateKey: PrivateKey = keyFactory.generatePrivate(keySpec)

        // Crear el administrador de claves basado en el certificado del cliente y la clave privada
        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        keyStore.load(null)
        keyStore.setCertificateEntry("mqtt-client", clientCertificate)
        keyStore.setKeyEntry("mqtt-client-private", privateKey, password, arrayOf(clientCertificate))

        // Crear el administrador de claves
        val keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
        keyManagerFactory.init(keyStore, password)

        // Crear el administrador de confianza basado en el certificado de la Autoridad de Certificación (root CA)
        val rootCABytes = Base64.decode(secrets.rootCa, Base64.DEFAULT)

        val rootCAFactory = CertificateFactory.getInstance("X.509")
        val rootCACertificate = rootCAFactory.generateCertificate(ByteArrayInputStream(rootCABytes))

        val trustStore = KeyStore.getInstance(KeyStore.getDefaultType())
        trustStore.load(null)
        trustStore.setCertificateEntry("root-CA", rootCACertificate)

        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(trustStore)

        // Crear el contexto SSL
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(keyManagerFactory.keyManagers, trustManagerFactory.trustManagers, null)

        return sslContext.socketFactory
    }

}

