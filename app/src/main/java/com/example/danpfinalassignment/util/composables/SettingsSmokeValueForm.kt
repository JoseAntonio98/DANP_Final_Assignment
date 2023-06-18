@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.danpfinalassignment.ui.theme.DarkGrayColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SettingsAddCancel
import com.example.danpfinalassignment.ui.theme.SettingsAddSmokeInput
import com.example.danpfinalassignment.ui.theme.SettingsAddTitle
import com.example.danpfinalassignment.ui.theme.SettingsAddUpdate
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeSmall
import com.example.danpfinalassignment.ui.theme.TextSizeH3

@Composable
fun SettingsSmokeValueForm(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    var smokeValue by remember { mutableStateOf("") }

    /* TODO: Moved fixed values to Values file */
    /* TODO: Improved padding in Dialog */
    if (showDialog) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, color = SecondaryColor, shape = RoundedCornerShape(15.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = SettingsAddTitle,
                        fontSize = TextSizeH3,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(SizeLarge))

                    Column {
                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            label = { Text(text = SettingsAddSmokeInput) },
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { smokeValue = it },
                            shape = RoundedCornerShape(SizeMedium),
                            singleLine = true,
                            value = smokeValue
                        )

                        Spacer(modifier = Modifier.height(SizeExtraLarge))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = DarkGrayColor,
                                    containerColor = SecondaryColor
                                ),
                                elevation = ButtonDefaults.buttonElevation(5.dp),
                                onClick = {
                                    onDismiss()
                                }
                            ) {
                                Text(
                                    text = SettingsAddCancel,
                                    color = DarkGrayColor,
                                    fontSize = 16.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(SizeSmall))

                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = SecondaryColor,
                                    containerColor = PrimaryColor
                                ),
                                elevation = ButtonDefaults.buttonElevation(5.dp),
                                onClick = {
                                    onConfirm()
                                }
                            ) {
                                Text(
                                    text = SettingsAddUpdate,
                                    color = SecondaryColor,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}