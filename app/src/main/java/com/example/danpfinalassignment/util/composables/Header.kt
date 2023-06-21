package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.example.danpfinalassignment.ui.theme.PrimaryColor

@Composable
fun Header () {

    Box(modifier = Modifier
        .fillMaxSize()
        .drawBehind {
            drawCircle(
                color = PrimaryColor,
                center = Offset(x = size.width / 2, y = 0f),
                radius = size.minDimension
            )
        })
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppHeader()
        }
    }


}