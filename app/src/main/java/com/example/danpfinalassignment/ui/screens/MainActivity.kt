package com.example.danpfinalassignment.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.danpfinalassignment.ui.theme.DANPFinalAssignmentTheme
import com.example.danpfinalassignment.ui.theme.TertiaryColor
import com.example.danpfinalassignment.util.navigation.NavigationAppHost

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
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}