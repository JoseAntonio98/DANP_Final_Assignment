package com.example.danpfinalassignment.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.amplifyframework.ui.authenticator.enums.AuthenticatorStep
import com.example.danpfinalassignment.ui.theme.DANPFinalAssignmentTheme
import com.example.danpfinalassignment.ui.theme.TertiaryColor
import com.example.danpfinalassignment.util.navigation.NavigationAppHost
import com.amplifyframework.ui.authenticator.rememberAuthenticatorState
import com.amplifyframework.ui.authenticator.ui.Authenticator
import com.example.danpfinalassignment.util.composables.Header

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DANPFinalAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    // color = MaterialTheme.colorScheme.background
                    color = TertiaryColor
                ) {

                    val authenticatorState = rememberAuthenticatorState(
                        initialStep = AuthenticatorStep.SignIn,
                        signUpForm = {
                            username()
                            email()
                            password()
                            confirmPassword()
                        }
                    )
                    Authenticator (
                        state = authenticatorState,
                        headerContent = { Header() },
                        //signInContent = { state -> LoginScreen(state = state)},
                        //signUpContent = { state -> RegisterScreen(state = state)},
                    ) {state ->
                        //val username = state.user.username
                        //state.signOut() -> coroutine -> scope.launch
                        val navController = rememberNavController()
                        NavigationAppHost(navController = navController, state = state)
                    }
                }
            }
        }
    }
}