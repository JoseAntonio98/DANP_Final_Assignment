package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.AppName
import com.example.danpfinalassignment.ui.theme.ImageSizeLarge
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeMedium

@Composable
fun AppHeader() {
    Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = AppName,
            color = SecondaryColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
        )
    }

    Image(
        painter = painterResource(id = R.drawable.app_logo),
        contentDescription = "App Logo",
        modifier = Modifier.size(ImageSizeLarge)
    )

    Spacer(modifier = Modifier.height(SizeMedium))
}