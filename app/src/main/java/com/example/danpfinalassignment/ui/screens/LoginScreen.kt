@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danpfinalassignment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amplifyframework.ui.authenticator.SignInState
import com.amplifyframework.ui.authenticator.forms.FieldKey
import com.amplifyframework.ui.authenticator.ui.SignInFooter
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.DarkBlackColor
import com.example.danpfinalassignment.ui.theme.DarkGrayColor
import com.example.danpfinalassignment.ui.theme.LoginButton
import com.example.danpfinalassignment.ui.theme.LoginButtonGoogle
import com.example.danpfinalassignment.ui.theme.LoginLabelFieldEmail
import com.example.danpfinalassignment.ui.theme.LoginTextFieldEmail
import com.example.danpfinalassignment.ui.theme.LoginTextFieldPassword
import com.example.danpfinalassignment.ui.theme.LoginTitle
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeSmall
import com.example.danpfinalassignment.ui.theme.TextSizeP1
import com.example.danpfinalassignment.util.composables.AppHeader
import com.example.danpfinalassignment.util.composables.BackgroundCircle
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.danpfinalassignment.ui.theme.LoginLabelFieldPassword

@Composable
fun LoginScreen (state: SignInState) {
    val scope = rememberCoroutineScope()
    val email = state.form.fields[FieldKey.Email]!!
    val password = state.form.fields[FieldKey.Password]!!

    val focusManager = LocalFocusManager.current
    var passwordVisible by remember { mutableStateOf(false) }

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
                text = LoginTitle,
                fontSize = 22.sp,
                color = DarkBlackColor,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(SizeMedium))

            /* TODO: ADD ICON*/
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                enabled = true,
                value = email.state.content,
                onValueChange = { email.state.content = it.take(240) },
                label = { Text(text = LoginLabelFieldEmail)},
                placeholder = { Text(text = LoginTextFieldEmail) },
                maxLines = 1,
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Next) }
                )
            )

            Spacer(modifier = Modifier.height(SizeSmall))

            /* TODO: ADD HIDE PASSWORD FUNCTIONALITY */
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                enabled = true,
                value = password.state.content,
                onValueChange = {password.state.content = it},
                label = { Text(text = LoginLabelFieldPassword)},
                placeholder = { Text(text = LoginTextFieldPassword) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(SizeMedium),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Next) }
                ),
                trailingIcon = getTrailingIcon (
                    passwordVisible,
                    onClick = { passwordVisible = !passwordVisible}
                )



            )

            Spacer(modifier = Modifier.height(SizeLarge))

            Column {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = SecondaryColor,
                        containerColor = PrimaryColor
                    ),
                    elevation = ButtonDefaults.buttonElevation(5.dp),
                    onClick = {
                        scope.launch { state.signIn() }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(text = LoginButton, color = SecondaryColor, fontSize = TextSizeP1)
                }

                Spacer(modifier = Modifier.height(SizeSmall))

                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = DarkGrayColor,
                        containerColor = SecondaryColor
                    ),
                    elevation = ButtonDefaults.buttonElevation(5.dp),
                    onClick = { /* TODO */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(SizeMedium)
                    )

                    Spacer(modifier = Modifier.width(SizeSmall))

                    Text(text = LoginButtonGoogle, color = DarkGrayColor, fontSize = TextSizeP1)
                }
            }

            SignInFooter(state = state)

        }
    }
}

private fun getTrailingIcon(visible: Boolean, onClick: () -> Unit): @Composable (() -> Unit) {
    return {
        val icon = when (visible) {
            false -> androidx.navigation.ui.R.drawable.design_ic_visibility_off
            true -> androidx.navigation.ui.R.drawable.design_ic_visibility
        }
        val contentDescription = when (visible) {
            true -> "visibility icon"
            false -> "visibility off icon"
        }
        IconButton(onClick = onClick) {
            Icon(painter = painterResource(icon), contentDescription = contentDescription)
        }
    }
}