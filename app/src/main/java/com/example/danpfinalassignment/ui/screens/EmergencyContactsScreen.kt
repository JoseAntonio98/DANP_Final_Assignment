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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.ContactsEmptyMessage
import com.example.danpfinalassignment.ui.theme.ContactsTitle
import com.example.danpfinalassignment.ui.theme.DarkGrayColor
import com.example.danpfinalassignment.ui.theme.ImageSizeLarge
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeCircularShape
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeMedium20
import com.example.danpfinalassignment.ui.theme.TextSizeH2
import com.example.danpfinalassignment.util.composables.AppTitle

@Composable
fun EmergencyContactsScreen(navController: NavHostController) {
    val isContactsEmpty = true

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
                    text = ContactsTitle,
                    fontSize = TextSizeH2,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            if (isContactsEmpty) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.history_empty),
                        contentDescription = "Contacts Empty",
                        modifier = Modifier.width(ImageSizeLarge)
                    )

                    Spacer(modifier = Modifier.height(SizeMedium))

                    Text(text = ContactsEmptyMessage, color = DarkGrayColor)
                }
            } else {
                Text("Coming soon")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SizeMedium20),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            containerColor = PrimaryColor,
            contentColor = SecondaryColor,
            onClick = {
                /* TODO */
                // showDialog = true
            },
            shape = RoundedCornerShape(SizeCircularShape)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }
}