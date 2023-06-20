package com.example.danpfinalassignment.util.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val title: String, val route: String, val icon: ImageVector) {
    object EmergencyContacts :
        Destination("Emergency Contacts", "emergency_contacts", Icons.Default.Call)

    object History : Destination("History", "history", Icons.Default.List)
    object Home : Destination("Home", "home", Icons.Default.Home)
    object Login : Destination("Login", "login", Icons.Default.Face)
    object Register : Destination("Register", "register", Icons.Default.Face)
    object RegisterVerification :
        Destination("Register Verification", "register_verification", Icons.Default.Face)

    object Settings : Destination("Settings", "settings", Icons.Default.Settings)
}
