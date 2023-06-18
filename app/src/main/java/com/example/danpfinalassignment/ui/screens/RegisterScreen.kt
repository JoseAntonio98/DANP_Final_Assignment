@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.danpfinalassignment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.ui.theme.DarkBlackColor
import com.example.danpfinalassignment.ui.theme.GrayColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.RegisterButton
import com.example.danpfinalassignment.ui.theme.RegisterTextFieldEmail
import com.example.danpfinalassignment.ui.theme.RegisterTextFieldFullName
import com.example.danpfinalassignment.ui.theme.RegisterTextFieldPassword
import com.example.danpfinalassignment.ui.theme.RegisterTitle
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeSmall
import com.example.danpfinalassignment.util.composables.AppHeader
import com.example.danpfinalassignment.util.composables.BackgroundCircle
import com.example.danpfinalassignment.util.navigation.Destination

@Composable
fun RegisterScreen(navController: NavHostController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isChecked by remember { mutableStateOf(false) }

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
                text = RegisterTitle,
                fontSize = 22.sp,
                color = DarkBlackColor,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(SizeMedium))

            /* TODO: ADD ICON*/
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = RegisterTextFieldFullName) },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { fullName = it },
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                value = fullName
            )

            Spacer(modifier = Modifier.height(SizeSmall))

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(text = RegisterTextFieldEmail) },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { email = it },
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                value = email
            )

            Spacer(modifier = Modifier.height(SizeSmall))

            /* TODO: ADD HIDE PASSWORD FUNCTIONALITY */
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(text = RegisterTextFieldPassword) },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { password = it },
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                value = password,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,

                ) {
                Checkbox(
                    checked = isChecked,
                    colors = CheckboxDefaults.colors(
                        checkedColor = PrimaryColor
                    ),
                    onCheckedChange = { isChecked = it })
                Text(text = "Accept Terms and Conditions", color = GrayColor, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                onClick = {
                    navController.navigate(Destination.RegisterVerification.route)
                    /* TODO */
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(text = RegisterButton, color = SecondaryColor, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(SizeSmall))

            Row {
                Text(text = "Are you registered?", color = GrayColor, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier.clickable { navController.navigate(Destination.Login.route) },
                    text = "Login",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
        }
    }
}