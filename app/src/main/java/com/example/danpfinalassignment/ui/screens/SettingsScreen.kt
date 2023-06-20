package com.example.danpfinalassignment.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.DarkGrayColor
import com.example.danpfinalassignment.ui.theme.ImageSizeCard
import com.example.danpfinalassignment.ui.theme.LightBlackColor
import com.example.danpfinalassignment.ui.theme.LightGrayColor
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.ui.theme.SettingsAlerts
import com.example.danpfinalassignment.ui.theme.SettingsChangePassword
import com.example.danpfinalassignment.ui.theme.SettingsLogout
import com.example.danpfinalassignment.ui.theme.SettingsPersonalData
import com.example.danpfinalassignment.ui.theme.SettingsSound
import com.example.danpfinalassignment.ui.theme.SettingsSubtitle
import com.example.danpfinalassignment.ui.theme.SettingsTitle
import com.example.danpfinalassignment.ui.theme.SettingsUpdateSmokeValue
import com.example.danpfinalassignment.ui.theme.SizeExtraLarge
import com.example.danpfinalassignment.ui.theme.SizeLarge
import com.example.danpfinalassignment.ui.theme.SizeMedium
import com.example.danpfinalassignment.ui.theme.SizeMedium20
import com.example.danpfinalassignment.ui.theme.SizeSmall
import com.example.danpfinalassignment.ui.theme.TextSizeH1
import com.example.danpfinalassignment.ui.theme.TextSizeH2
import com.example.danpfinalassignment.ui.theme.TextSizeP1
import com.example.danpfinalassignment.ui.theme.TextSizeP2
import com.example.danpfinalassignment.util.composables.AppTitle
import com.example.danpfinalassignment.util.composables.SettingsSmokeValueForm
import com.example.danpfinalassignment.util.navigation.Destination

@Composable
fun SettingsScreen(navController: NavHostController) {
    var isAlertChecked by remember { mutableStateOf(false) }
    var isSoundChecked by remember { mutableStateOf(false) }

    var showDialog by rememberSaveable { mutableStateOf(false) }

    /* TODO: Convert to LazyColumn to Scroll in small devices */
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
            /* TODO: Convert to Composable */
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = SettingsTitle,
                    fontSize = TextSizeH1,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            /* PERSONAL DATA */
            Column {
                Text(
                    text = SettingsPersonalData,
                    fontSize = TextSizeH2,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(SizeMedium))

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(SizeMedium))
                        .background(color = LightGrayColor)
                        .padding(12.dp, 8.dp)
                        .fillMaxWidth()
                        .height(64.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "User picture",
                        modifier = Modifier.size(ImageSizeCard)
                    )

                    Spacer(modifier = Modifier.width(SizeSmall))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Angel Perez",
                            fontWeight = FontWeight.Bold,
                            fontSize = TextSizeP1,
                            color = LightBlackColor
                        )
                        Text(
                            text = "angel@gmail.com",
                            fontSize = TextSizeP2,
                            color = PrimaryColor
                        )
                    }
                }

                Spacer(modifier = Modifier.height(SizeMedium))

                /* TODO: CONVERT TO COMPOSABLE */
                /* CHANGE PASSWORD */
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(SizeSmall))
                        .background(color = LightGrayColor)
                        .padding(SizeMedium, SizeMedium)
                        .fillMaxWidth()
                        .clickable { /* TODO */ },
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = SettingsChangePassword,
                        tint = DarkGrayColor,
                        modifier = Modifier.size(SizeMedium20)
                    )

                    Spacer(modifier = Modifier.width(SizeSmall))

                    Text(
                        text = SettingsChangePassword,
                        fontSize = TextSizeP1,
                        color = DarkGrayColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            /* SETTINGS */
            Column {
                Text(
                    text = SettingsSubtitle,
                    fontSize = TextSizeH2,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(SizeMedium))

                /* TODO: CONVERT TO COMPOSABLE */
                /* ALERTS */
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(SizeSmall))
                        .background(color = LightGrayColor)
                        .padding(SizeMedium, SizeMedium)
                        .fillMaxWidth()
                        .height(28.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = SettingsAlerts,
                            tint = DarkGrayColor,
                            modifier = Modifier.size(SizeMedium20)
                        )

                        Spacer(modifier = Modifier.width(SizeSmall))

                        Text(
                            text = SettingsAlerts,
                            fontSize = TextSizeP1,
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
                            checked = isAlertChecked,
                            colors = CheckboxDefaults.colors(
                                checkedColor = PrimaryColor
                            ),
                            onCheckedChange = { isAlertChecked = it })
                    }
                }

                Spacer(modifier = Modifier.height(SizeSmall))

                /* TODO: CONVERT TO COMPOSABLE */
                /* SOUND */
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(SizeSmall))
                        .background(color = LightGrayColor)
                        .padding(SizeMedium, SizeMedium)
                        .fillMaxWidth()
                        .height(28.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            Icons.Default.Call,
                            contentDescription = SettingsSound,
                            tint = DarkGrayColor,
                            modifier = Modifier.size(SizeMedium20)
                        )

                        Spacer(modifier = Modifier.width(SizeSmall))

                        Text(
                            text = SettingsSound,
                            fontSize = TextSizeP1,
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
                            checked = isSoundChecked,
                            colors = CheckboxDefaults.colors(
                                checkedColor = PrimaryColor
                            ),
                            onCheckedChange = { isSoundChecked = it })
                    }
                }

                Spacer(modifier = Modifier.height(SizeSmall))

                /* TODO: CONVERT TO COMPOSABLE */
                /* TODO: Make Clickable */
                /* UPDATE SMOKE VALUE LIMIT */
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(SizeSmall))
                        .background(color = LightGrayColor)
                        .padding(SizeMedium, SizeMedium)
                        .fillMaxWidth()
                        .clickable { showDialog = true },
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Icon(
                        Icons.Default.Warning,
                        contentDescription = SettingsUpdateSmokeValue,
                        tint = DarkGrayColor,
                        modifier = Modifier.size(SizeMedium20)
                    )

                    Spacer(modifier = Modifier.width(SizeSmall))

                    Text(
                        text = SettingsUpdateSmokeValue,
                        fontSize = TextSizeP1,
                        color = DarkGrayColor
                    )
                }

                Spacer(modifier = Modifier.height(SizeSmall))

                /* TODO: CONVERT TO COMPOSABLE */
                /* LOGOUT */
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(SizeSmall))
                        .background(color = LightGrayColor)
                        .padding(SizeMedium, SizeMedium)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Destination.Login.route)
                            /* TODO: Implement Logout functionality */
                        },
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Icon(
                        Icons.Default.ExitToApp,
                        contentDescription = SettingsLogout,
                        tint = DarkGrayColor,
                        modifier = Modifier.size(SizeMedium20)
                    )

                    Spacer(modifier = Modifier.width(SizeSmall))

                    Text(
                        text = SettingsLogout,
                        fontSize = TextSizeP1,
                        color = DarkGrayColor
                    )
                }
            }

        }
    }

    /* TODO: Change functions onDismiss and onConfirm */
    SettingsSmokeValueForm(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = { showDialog = false }
    )
}