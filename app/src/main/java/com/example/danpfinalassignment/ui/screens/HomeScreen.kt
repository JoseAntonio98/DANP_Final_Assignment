package com.example.danpfinalassignment.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.DarkBlackColor
import com.example.danpfinalassignment.ui.theme.HomeActivateSmokeDisperserButton
import com.example.danpfinalassignment.ui.theme.HomeSmokeDetected
import com.example.danpfinalassignment.ui.theme.HomeViewHistoryButton
import com.example.danpfinalassignment.ui.theme.ImageSizeLarge
import com.example.danpfinalassignment.ui.theme.ImageWidthLarge
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeTopBar
import com.example.danpfinalassignment.ui.theme.TextSizeP1
import com.example.danpfinalassignment.ui.theme.textSizeLarge
import com.example.danpfinalassignment.util.composables.DrawerContent
import com.example.danpfinalassignment.util.composables.NavDrawer
import com.example.danpfinalassignment.util.composables.TopBar
import com.example.danpfinalassignment.util.navigation.Destination
import kotlinx.coroutines.launch
import org.json.JSONObject

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    /* TODO: Value to test image. CHANGE for data from Cloud */
    val isHistoryEmpty = true
    val context = LocalContext.current
    var valorSensor = remember { mutableStateOf("300") }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    lateinit var mqttBroker: MqttBroker;

    mqttBroker = MqttBroker(
        "ssl://ahee5r1ym27qz-ats.iot.sa-east-1.amazonaws.com:8883",
        "LocalClient",
        context
    )
    mqttBroker.connect()


    NavDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController = navController, scope = scope, drawerState = drawerState)
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    title = Destination.Home.title,
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu Bars")
                        }
                    }
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = SizeMedium, vertical = SizeTopBar + 4.dp)
                    .background(SecondaryColor),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {

                items(1) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(SizeLarge))

//                      Metodo de suscripcion al broker
                        mqttBroker.subscribe("esp32/movil") { valor ->
                            val jsonObject = JSONObject(valor)
                            val sensorsArray = jsonObject.getJSONArray("Sensors")
                            if (sensorsArray.length() > 0) {
                                val dataObj = sensorsArray.getJSONObject(0)
                                val dataString = dataObj.getString("Data")
                                val dataJson = JSONObject(dataString)
                                val sensorValue = dataJson.getInt("value")
                                valorSensor.value = sensorValue.toString()
                            }
                        }

                        /* TODO: Make CIRCULAR shape*/
                        Text(
                            /* TODO: Replace fixed value to CLOUD value */
                            text = valorSensor.value,
                            color = DarkBlackColor,
                            fontSize = textSizeLarge
                        )

                        Spacer(modifier = Modifier.height(SizeMedium))

                        Text(text = HomeSmokeDetected)

                        Spacer(modifier = Modifier.height(SizeMedium))

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                contentColor = SecondaryColor,
                                containerColor = PrimaryColor
                            ),
                            elevation = ButtonDefaults.buttonElevation(5.dp),
                            onClick = {
                                mqttBroker.publish("movil/esp32", "{\n" +
                                        "  \"action\": \"prender\"\n" +
                                        "  \"value\": \"${valorSensor}\"\n" +
                                        "}")
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = HomeActivateSmokeDisperserButton,
                                color = SecondaryColor,
                                fontSize = TextSizeP1
                            )
                        }

                        Spacer(modifier = Modifier.height(SizeLarge))

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                contentColor = SecondaryColor,
                                containerColor = PrimaryColor
                            ),
                            elevation = ButtonDefaults.buttonElevation(5.dp),
                            onClick = {

                                mqttBroker.publish("movil/esp32", "{\n" +
                                        "  \"action\": \"apagar\"\n" +
                                        "  \"value\": \"0\"\n" +
                                        "}")
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Apagar Dispersor",
                                color = SecondaryColor,
                                fontSize = TextSizeP1
                            )
                        }

                        Spacer(modifier = Modifier.height(SizeExtraLarge))

                        if (isHistoryEmpty) {
                            Image(
                                painter = painterResource(id = R.drawable.home_empty),
                                contentDescription = "Empty Home",
                                modifier = Modifier.width(ImageSizeLarge)
                            )
                        } else {
                            Image(
                                painter = painterResource(id = R.drawable.chart_soon),
                                contentDescription = "Chart",
                                modifier = Modifier.width(ImageWidthLarge)
                            )
                        }

                        Spacer(modifier = Modifier.height(SizeLarge))

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                contentColor = SecondaryColor,
                                containerColor = PrimaryColor
                            ),
                            elevation = ButtonDefaults.buttonElevation(5.dp),
                            onClick = {
                                navController.navigate(Destination.History.route)
                                /* TODO */
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = HomeViewHistoryButton,
                                color = SecondaryColor,
                                fontSize = TextSizeP1
                            )
                        }

                    }
                }
            }
        }
    }
}