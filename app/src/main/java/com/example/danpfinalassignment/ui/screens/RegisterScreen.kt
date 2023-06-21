@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.danpfinalassignment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danpfinalassignment.ui.theme.DarkBlackColor
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
import com.amplifyframework.ui.authenticator.SignUpState
import com.amplifyframework.ui.authenticator.forms.FieldKey
import com.amplifyframework.ui.authenticator.ui.SignUpFooter
import com.example.danpfinalassignment.ui.theme.RegisterTextFieldConfirmPassword
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(state: SignUpState) {

    val scope = rememberCoroutineScope()
    val email = state.form.fields[FieldKey.Email]!!
    val password = state.form.fields[FieldKey.Password]!!
    val confirmPassword = state.form.fields[FieldKey.ConfirmPassword]!!
    val username = state.form.fields[FieldKey.Username]!!

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
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                placeholder = { Text(text = RegisterTextFieldFullName) },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { username.state.content = it },
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                value = username.state.content
            )

            Spacer(modifier = Modifier.height(SizeSmall))

            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(text = RegisterTextFieldEmail) },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { email.state.content = it },
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                value = email.state.content
            )

            Spacer(modifier = Modifier.height(SizeSmall))

            /* TODO: ADD HIDE PASSWORD FUNCTIONALITY */
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(text = RegisterTextFieldPassword) },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { password.state.content = it },
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                value = password.state.content
            )
            
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(text = RegisterTextFieldConfirmPassword) },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { confirmPassword.state.content = it },
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                value = confirmPassword.state.content
            )

            /*
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
                Text(text = RegisterAcceptTerms, color = DarkGrayColor, fontSize = 14.sp)
            }

             */

            Spacer(modifier = Modifier.height(SizeLarge))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                onClick = {
                    scope.launch { state.signUp() }
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(text = RegisterButton, color = SecondaryColor, fontSize = 16.sp)
            }
            
            SignUpFooter(state = state)

            /*
            Spacer(modifier = Modifier.height(SizeSmall))

            Row {
                Text(text = RegisterRegistered, color = DarkGrayColor, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier.clickable { navController.navigate(Destination.Login.route) },
                    text = RegisterToLogin,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
            */
        }
    }
}