package com.example.teamsklent_electricvehicles_2023
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Face

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "Home"
        ),
        BarItem(
            title = "Logs",
            image = Icons.Filled.Edit,
            route = "Log"
        ),
        BarItem(
            title = "Account",
            image = Icons.Filled.Face,
            route = "Account"
        )
    )
}