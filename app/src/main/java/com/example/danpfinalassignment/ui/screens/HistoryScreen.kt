package com.example.danpfinalassignment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.GrayColor
import com.example.danpfinalassignment.ui.theme.HistoryEmptyMessage
import com.example.danpfinalassignment.ui.theme.HistoryTitle
import com.example.danpfinalassignment.ui.theme.ImageSizeLarge
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.TextSizeH2
import com.example.danpfinalassignment.util.composables.AppTitle
import com.example.danpfinalassignment.util.composables.HistoryItem

/* TODO: Temporal data class to test UI. REPLACE with Cloud Data */
data class ListItem(val date: String, val time: String, val value: Int)

@Composable
fun HistoryScreen(navController: NavHostController) {
    /* TODO: Temporal list to test UI. REPLACE with Cloud Data */
    // val historyItems = emptyList<ListItem>() /* EmptyList, only for test - DELETE */
    val historyItems = (1..20).map {
        ListItem(
            date = "Date $it",
            time = "Time $it",
            value = it
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SecondaryColor)
    ) {
        AppTitle(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SizeExtraLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = HistoryTitle,
                    fontSize = TextSizeH2,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            if (historyItems.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.history_empty),
                        contentDescription = "Empty History",
                        modifier = Modifier.width(ImageSizeLarge)
                    )

                    Spacer(modifier = Modifier.height(SizeMedium))

                    Text(text = HistoryEmptyMessage, color = GrayColor)
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chart_soon),
                        contentDescription = "Temporal Chart",
                        modifier = Modifier.width(ImageSizeLarge)
                    )

                    Spacer(modifier = Modifier.height(SizeExtraLarge))

                    LazyColumn(
                        contentPadding = PaddingValues(all = 4.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        /* TODO: Temporal iteration. REPLACE with Cloud data */
                        items(historyItems.size) {
                            HistoryItem()
                        }
                    }
                }
            }
        }
    }
}