package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.danpfinalassignment.ui.theme.DarkGrayColor
import com.example.danpfinalassignment.ui.theme.LightGrayColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeSmall
import com.example.danpfinalassignment.ui.theme.TextSizeP2

@Composable
fun ContactItem() {
    var isChecked by remember { mutableStateOf(false) }

    /* TODO: Improve Contact Items styles */
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(SizeSmall))
            .background(color = LightGrayColor)
            .padding(SizeMedium, SizeMedium)
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
                text = "Marie Ross Gonzales",
                fontWeight = FontWeight.Bold,
                fontSize = TextSizeP2,
                color = DarkGrayColor
            )
            Text(
                text = "988142414",
                fontSize = TextSizeP2,
                color = DarkGrayColor
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            /* TODO: Change for SWITCH component */
            Checkbox(
                checked = isChecked,
                colors = CheckboxDefaults.colors(
                    checkedColor = PrimaryColor
                ),
                onCheckedChange = { isChecked = it })
        }
    }
}