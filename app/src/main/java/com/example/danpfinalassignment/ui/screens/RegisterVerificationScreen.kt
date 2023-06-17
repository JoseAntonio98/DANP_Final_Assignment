@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danpfinalassignment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.ui.theme.DarkBlackColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeSmall
import com.example.danpfinalassignment.ui.theme.VerificationButton
import com.example.danpfinalassignment.ui.theme.VerificationMessage
import com.example.danpfinalassignment.ui.theme.VerificationTitle
import com.example.danpfinalassignment.util.composables.AppHeader
import com.example.danpfinalassignment.util.composables.BackgroundCircle
import com.example.danpfinalassignment.util.navigation.Destination

@Composable
fun RegisterVerificationScreen(navController: NavHostController) {
    var code1 by remember { mutableStateOf("") }
    var code2 by remember { mutableStateOf("") }
    var code3 by remember { mutableStateOf("") }
    var code4 by remember { mutableStateOf("") }

    BackgroundCircle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppHeader()

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(SecondaryColor)
                .padding(28.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = VerificationTitle,
                fontSize = 22.sp,
                color = DarkBlackColor,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(SizeLarge))

            Text(text = VerificationMessage)

            Spacer(modifier = Modifier.height(SizeLarge))

            Row {
                /* TODO: Could be refactored as a Composable */
                TextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    modifier = Modifier.weight(1f),
                    onValueChange = { code1 = it },
                    shape = RoundedCornerShape(SizeSmall),
                    singleLine = true,
                    value = code1
                )

                Spacer(modifier = Modifier.width(SizeSmall))

                TextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    modifier = Modifier.weight(1f),
                    onValueChange = { code2 = it },
                    shape = RoundedCornerShape(SizeSmall),
                    singleLine = true,
                    value = code2
                )

                Spacer(modifier = Modifier.width(SizeSmall))

                TextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    modifier = Modifier.weight(1f),
                    onValueChange = { code3 = it },
                    shape = RoundedCornerShape(SizeSmall),
                    singleLine = true,
                    value = code3
                )

                Spacer(modifier = Modifier.width(SizeSmall))

                TextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    modifier = Modifier.weight(1f),
                    onValueChange = { code4 = it },
                    shape = RoundedCornerShape(SizeSmall),
                    singleLine = true,
                    value = code4
                )
            }

            Spacer(modifier = Modifier.height(SizeExtraLarge))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                onClick = {
                    navController.navigate(Destination.Login.route)
                    /* TODO */
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = VerificationButton, color = SecondaryColor, fontSize = 16.sp)
            }
        }
    }
}