package com.example.teamsklent_electricvehicles_2023
/**
 * All of the navigable content screens
 */
sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("Home")
    object Logs : NavRoutes("Log")
    object Account : NavRoutes("Account")
    object Login : NavRoutes("Login")
    object Signup : NavRoutes("Signup")
    object Settings : NavRoutes("Settings")
    object Employees : NavRoutes("Employees")
    object FleetManagement : NavRoutes("JoinFleet")
}