package com.example.danpfinalassignment.util

sealed class Destination(val title: String, val route: String) {
    object EmergencyContacts : Destination("Emergency Contacts", "emergency_contacts")
    object History : Destination("History", "history")
    object Home : Destination("Home", "home")
    object Login : Destination("Login", "login")
    object Register : Destination("Register", "register")
    object RegisterVerification : Destination("Register Verification", "register_verification")
    object Settings : Destination("Settings", "settings")
}
