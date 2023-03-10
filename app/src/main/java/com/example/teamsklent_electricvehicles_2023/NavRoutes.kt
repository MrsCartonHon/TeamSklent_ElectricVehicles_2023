package com.example.teamsklent_electricvehicles_2023

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("Home")
    object Logs : NavRoutes("Log")
    object Account : NavRoutes("Account")
}