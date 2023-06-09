package com.example.danpfinalassignment.aws

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify

class MyAmplifyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Log.i("MyAmplifyApp", "Initialized Cognito")

            Amplify.configure(applicationContext)
            Log.i("MyAmplifyApp", "Initialized Amplify")

        } catch (error: AmplifyException) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error)
        }
    }
}