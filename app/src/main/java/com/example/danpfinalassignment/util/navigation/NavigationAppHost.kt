package com.example.danpfinalassignment.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.amplifyframework.ui.authenticator.SignedInState
import com.example.danpfinalassignment.ui.screens.EmergencyContactsScreen
import com.example.danpfinalassignment.ui.screens.HistoryScreen
import com.example.danpfinalassignment.ui.screens.HomeScreen
import com.example.danpfinalassignment.ui.screens.SettingsScreen

@Composable
fun NavigationAppHost(navController: NavHostController, state: SignedInState) {
    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(Destination.EmergencyContacts.route) { EmergencyContactsScreen(navController = navController) }
        composable(Destination.History.route) { HistoryScreen(navController = navController) }
        composable(Destination.Home.route) { HomeScreen(navController = navController) }
        // composable(Destination.Login.route) { LoginScreen(navController = navController) }
        // composable(Destination.Register.route) { RegisterScreen(navController = navController) }
        /*
        composable(Destination.RegisterVerification.route) {
            RegisterVerificationScreen(
                navController = navController
            )
        }
        */
        composable(Destination.Settings.route) { SettingsScreen(navController = navController, state = state) }
    }
}