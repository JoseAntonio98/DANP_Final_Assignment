package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.ui.theme.AppName
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.TextSizeH1
import com.example.danpfinalassignment.util.navigation.Destination

@Composable
fun AppTitle(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(PrimaryColor)
            .padding(SizeMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.Menu,
            contentDescription = "Bars Menu",
            tint = SecondaryColor,
            modifier = Modifier
                .size(SizeLarge)
                .clickable { navController.navigate(Destination.Login.route) }
        )

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = AppName,
                fontSize = TextSizeH1,
                color = SecondaryColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
