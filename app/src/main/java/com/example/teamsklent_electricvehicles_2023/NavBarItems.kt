package com.example.teamsklent_electricvehicles_2023
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
/**
 * All of the items in the NavigationBar
 */
object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "Home",
            navBar = true
        ),
        BarItem(
            title = "Logs",
            image = Icons.Filled.Edit,
            route = "Log",
            navBar = true
        ),
        BarItem(
            title = "Account",
            image = Icons.Filled.Face,
            route = "Account",
            navBar = true
        )
    )
}