package com.example.danpfinalassignment.util.composables

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.danpfinalassignment.ui.theme.ErrorColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.TertiaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String = "",
    navigationIcon: @Composable () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = navigationIcon,
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = PrimaryColor,
            titleContentColor = SecondaryColor,
            navigationIconContentColor = TertiaryColor,
            actionIconContentColor = ErrorColor
        )
    )
}