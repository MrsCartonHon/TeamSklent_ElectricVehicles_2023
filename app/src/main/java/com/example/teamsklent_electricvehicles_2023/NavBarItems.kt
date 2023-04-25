package com.example.teamsklent_electricvehicles_2023
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import com.example.teamsklent_electricvehicles_2023.models.BarItem

/**
 * All of the items in the NavigationBar
 */
object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            icon = Icons.Default.Home,
            iconSelected = Icons.Filled.Home,
            route = "Home"
        ),
        BarItem(
            title = "Logs",
            icon = Icons.Default.Edit,
            iconSelected = Icons.Filled.Edit,
            route = "Log"
        ),
        BarItem(
            title = "Settings",
            icon = Icons.Default.Face,
            iconSelected = Icons.Filled.Face,
            route = "Settings"
        )
    )
}