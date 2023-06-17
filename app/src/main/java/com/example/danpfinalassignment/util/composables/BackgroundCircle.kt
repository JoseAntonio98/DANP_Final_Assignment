package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import com.example.danpfinalassignment.ui.theme.PrimaryColor

@Composable
fun BackgroundCircle() {
    Box(modifier = Modifier
        .fillMaxSize()
        .drawBehind {
            drawCircle(
                color = PrimaryColor,
                center = Offset(x = size.width / 2, y = 0f),
                radius = size.minDimension
            )
        }) {
    }
}