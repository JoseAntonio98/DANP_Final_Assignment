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
import androidx.compose.ui.text.font.FontWeight
import com.example.danpfinalassignment.ui.theme.DarkGrayColor
import com.example.danpfinalassignment.ui.theme.LightGrayColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeSmall
import com.example.danpfinalassignment.ui.theme.TextSizeH4
import com.example.danpfinalassignment.ui.theme.TextSizeP2

@Composable
fun HistoryItem() {
    /* TODO: Improve History Items styles */
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(SizeSmall))
            .background(color = LightGrayColor)
            .padding(SizeMedium, SizeSmall)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Sunday, June 11 2023",
                fontWeight = FontWeight.Bold,
                fontSize = TextSizeP2,
                color = DarkGrayColor
            )
            Text(
                text = "07:28 AM",
                fontSize = TextSizeP2,
                color = DarkGrayColor
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "0.00",
                fontWeight = FontWeight.Bold,
                fontSize = TextSizeH4,
                color = PrimaryColor
            )
        }
    }
}