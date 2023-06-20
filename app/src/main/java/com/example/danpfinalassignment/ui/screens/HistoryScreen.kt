package com.example.danpfinalassignment.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.DarkGrayColor
import com.example.danpfinalassignment.ui.theme.HistoryEmptyMessage
import com.example.danpfinalassignment.ui.theme.ImageSizeLarge
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeTopBar
import com.example.danpfinalassignment.util.composables.DrawerContent
import com.example.danpfinalassignment.util.composables.HistoryItem
import com.example.danpfinalassignment.util.composables.NavDrawer
import com.example.danpfinalassignment.util.composables.TopBar
import com.example.danpfinalassignment.util.navigation.Destination
import kotlinx.coroutines.launch

/* TODO: Temporal data class to test UI. REPLACE with Cloud Data */
data class HistoryLog(val date: String, val time: String, val value: Int)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistoryScreen(navController: NavHostController) {
    /* TODO: Temporal list to test UI. REPLACE with Cloud Data */
    // val historyList = emptyList<HistoryLog>() /* EmptyList, only for test - DELETE */
    val historyList = (1..10).map {
        HistoryLog(
            date = "Date $it",
            time = "Time $it",
            value = it
        )
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController = navController, scope = scope, drawerState = drawerState)
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    title = Destination.History.title,
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu Bars")
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = SizeMedium, vertical = SizeTopBar + 4.dp)
                    .background(SecondaryColor)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(SizeLarge))

                    if (historyList.isEmpty()) {
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

                            Text(text = HistoryEmptyMessage, color = DarkGrayColor)
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
                                items(historyList.size) {
                                    HistoryItem()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}