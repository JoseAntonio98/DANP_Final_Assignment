package com.example.danpfinalassignment.util.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.danpfinalassignment.R
import com.example.danpfinalassignment.ui.theme.PrimaryColor
import com.example.danpfinalassignment.ui.theme.SecondaryColor
import com.example.danpfinalassignment.util.navigation.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer(
    drawerState: DrawerState,
    drawerContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    // Avoid use drawer with other nav components: bottomNav, tabNav, rail
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            drawerContent()
        },
        gesturesEnabled = true,
    ) {
        content()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState,
) {
    val itemsList = listOf(
        Destination.Home,
        Destination.History,
        Destination.EmergencyContacts,
        Destination.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    ModalDrawerSheet {
        // Header
        Column(
            Modifier
                .fillMaxWidth()
                .background(PrimaryColor)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User",
                modifier = Modifier.height(160.dp).fillMaxWidth(),
            )
            Text(
                text = "Hello @User",
                modifier = Modifier.padding(10.dp),
                fontSize = 24.sp,
                color = SecondaryColor,
                fontWeight = FontWeight.Bold
            )
        }

        // Menu Items
        itemsList.forEach { navDrawerItem ->
            NavigationDrawerItem(
                modifier = Modifier.padding(8.dp),
                icon = {
                    Icon(
                        imageVector = navDrawerItem.icon,
                        contentDescription = navDrawerItem.title
                    )
                },
                label = {
                    Text(
                        text = navDrawerItem.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                selected = currentRoute == navDrawerItem.route,
                onClick = {
                    scope.launch { drawerState.close() }
                    if (navDrawerItem.route != currentRoute) {
                        navController.navigate(navDrawerItem.route)
                    }
                }
            )
        }
    }
}