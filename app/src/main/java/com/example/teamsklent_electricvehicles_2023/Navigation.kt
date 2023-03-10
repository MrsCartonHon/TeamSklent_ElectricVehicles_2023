package com.example.teamsklent_electricvehicles_2023

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamsklent_electricvehicles_2023.Destinations.SIGN_IN_ROUTE
import com.example.teamsklent_electricvehicles_2023.Destinations.WELCOME_ROUTE
import com.example.teamsklent_electricvehicles_2023.screens.SignIn

object Destinations {
    const val WELCOME_ROUTE = "welcome"
    const val SIGN_IN_ROUTE = "signin"
}

@Composable
fun ElectricVehicleNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = SIGN_IN_ROUTE) {
        composable(SIGN_IN_ROUTE) {
            SignIn()
        }
    }
}