package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danpfinalassignment.ui.theme.GrayColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SizeMedium

@Composable
fun HistoryItem() {
    /* TODO: Improve History Items styles */
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(SizeMedium))
            .background(color = Color(245, 245, 245))
            .padding(12.dp, 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Date",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = GrayColor
            )
            Text(
                text = "Time",
                fontSize = 14.sp,
                color = GrayColor
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "15.50",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = PrimaryColor
            )
        }
    }
}