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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.ContactsDescription
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
import com.example.danpfinalassignment.ui.theme.TextSizeH1
import com.example.danpfinalassignment.util.composables.AppTitle
import com.example.danpfinalassignment.util.composables.ContactItem
import com.example.danpfinalassignment.util.composables.EmergencyContactsAddForm

/* TODO: Temporal data class to test UI. REPLACE with Cloud Data */
data class Contact(val fullName: String, val phone: String, val notify: Boolean)

@Composable
fun EmergencyContactsScreen(navController: NavHostController) {
    /* TODO: Temporal list to test UI. REPLACE with Cloud Data */
    // val contactsList = emptyList<Contact>() /* EmptyList, only for test - DELETE */
    val contactsList = (1..5).map {
        Contact(
            fullName = "FullName $it",
            phone = "Phone $it",
            notify = true
        )
    }

    var showDialog by rememberSaveable { mutableStateOf(false) }

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
                    fontSize = TextSizeH1,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(SizeLarge))

            if (contactsList.isEmpty()) {
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
                /* TODO: Decrease padding of Main screen */
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = ContactsDescription,
                            color = DarkGrayColor,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(SizeLarge))

                    LazyColumn(
                        contentPadding = PaddingValues(all = 4.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        /* TODO: Temporal iteration. REPLACE with Cloud data */
                        items(contactsList.size) {
                            ContactItem()
                        }
                    }
                }
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
                showDialog = true
            },
            shape = RoundedCornerShape(SizeCircularShape)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }

    EmergencyContactsAddForm(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = { showDialog = false })
}