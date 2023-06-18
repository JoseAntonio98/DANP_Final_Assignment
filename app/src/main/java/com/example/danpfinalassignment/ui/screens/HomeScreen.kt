package com.example.danpfinalassignment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.DarkBlackColor
import com.example.danpfinalassignment.ui.theme.HomeActivateSmokeDisperserButton
import com.example.danpfinalassignment.ui.theme.HomeSmokeDetected
import com.example.danpfinalassignment.ui.theme.HomeTitle
import com.example.danpfinalassignment.ui.theme.HomeViewHistoryButton
import com.example.danpfinalassignment.ui.theme.ImageSizeLarge
import com.example.danpfinalassignment.ui.theme.ImageWidthLarge
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.TextSizeH2
import com.example.danpfinalassignment.ui.theme.TextSizeP
import com.example.danpfinalassignment.ui.theme.textSizeLarge
import com.example.danpfinalassignment.util.composables.AppTitle
import com.example.danpfinalassignment.util.navigation.Destination

@Composable
fun HomeScreen(navController: NavHostController) {
    /* TODO: Value to test image. CHANGE for data from Cloud */
    val isHistoryEmpty = true

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
                    text = HomeTitle,
                    fontSize = TextSizeH2,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            /* TODO: Make CIRCULAR shape*/
            Text(
                /* TODO: Replace fixed value to CLOUD value */
                text = "0.00",
                color = DarkBlackColor,
                fontSize = textSizeLarge
            )

            Spacer(modifier = Modifier.height(SizeMedium))

            Text(text = HomeSmokeDetected)

            Spacer(modifier = Modifier.height(SizeMedium))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                onClick = {
                    /* TODO */
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = HomeActivateSmokeDisperserButton,
                    color = SecondaryColor,
                    fontSize = TextSizeP
                )
            }

            Spacer(modifier = Modifier.height(SizeExtraLarge))

            if (isHistoryEmpty) {
                Image(
                    painter = painterResource(id = R.drawable.home_empty),
                    contentDescription = "Empty Home",
                    modifier = Modifier.width(ImageSizeLarge)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.chart_soon),
                    contentDescription = "Chart",
                    modifier = Modifier.width(ImageWidthLarge)
                )
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                onClick = {
                    navController.navigate(Destination.History.route)
                    /* TODO */
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = HomeViewHistoryButton,
                    color = SecondaryColor,
                    fontSize = TextSizeP
                )
            }
        }
    }
}