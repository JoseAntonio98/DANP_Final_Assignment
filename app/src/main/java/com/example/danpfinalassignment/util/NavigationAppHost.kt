package com.example.danpfinalassignment.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.danpfinalassignment.ui.screens.EmergencyContactsScreen
import com.example.danpfinalassignment.ui.screens.HistoryScreen
import com.example.danpfinalassignment.ui.screens.HomeScreen
import com.example.danpfinalassignment.ui.screens.LoginScreen
import com.example.danpfinalassignment.ui.screens.RegisterScreen
import com.example.danpfinalassignment.ui.screens.RegisterVerificationScreen
import com.example.danpfinalassignment.ui.screens.SettingsScreen

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.Login.route) {
        composable(Destination.EmergencyContacts.route) { EmergencyContactsScreen(navController = navController) }
        composable(Destination.History.route) { HistoryScreen(navController = navController) }
        composable(Destination.Home.route) { HomeScreen(navController = navController) }
        composable(Destination.Login.route) { LoginScreen(navController = navController) }
        composable(Destination.Register.route) { RegisterScreen(navController = navController) }
        composable(Destination.RegisterVerification.route) {
            RegisterVerificationScreen(
                navController = navController
            )
        }
        composable(Destination.Settings.route) { SettingsScreen(navController = navController) }
    }
}