@file:OptIn(ExperimentalMaterial3Api::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.teamsklent_electricvehicles_2023

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.teamsklent_electricvehicles_2023.models.*
import com.example.teamsklent_electricvehicles_2023.screens.*
import com.example.teamsklent_electricvehicles_2023.ui.theme.*
import com.google.firebase.auth.FirebaseAuth


class MainActivity : ComponentActivity() {

    // [START declare_auth]
    private var auth: FirebaseAuth? = null
    // [END declare_auth]

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        // val currentUser = auth.currentUser
//        updateUI(currentUser)
        setContent {
            TeamSklent_ElectricVehicles_2023Theme {
                MainScreen(auth)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MainScreen(auth: FirebaseAuth?) {
    val navController = rememberNavController()
    Scaffold(
        //topBar = { TopAppBar(title = { Text("Bottom Navigation Demo") }) },
        content = { NavigationHost(navController = navController) },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )
}

@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login.route,
    ) {
        composable(NavRoutes.Home.route) {
            Home(navController)
        }
        composable(NavRoutes.Account.route) {
            Account(navController)
        }
        composable(NavRoutes.Logs.route) {
            Logs(navController)
        }
        composable(NavRoutes.Login.route){
            Login(navController)
        }
        composable(NavRoutes.Signup.route){
            Signup(navController)
        }
        composable(NavRoutes.Settings.route){
            Settings(navController)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar (
        containerColor = JDGreen1
    ){
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        NavBarItems.BarItems.forEach { navItem ->

            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if(currentRoute == navItem.route) {
                        Icon(
                            imageVector = navItem.iconSelected,
                            contentDescription = navItem.title,
                            tint = JDYellow
                        )
                    }else{
                        Icon(
                            imageVector = navItem.icon,
                            contentDescription = navItem.title,
                            tint = JDBlack
                        )
                    }
                },
                label = {
                    Text(text = navItem.title)
                },
                alwaysShowLabel = false,
            )
        }
    }
}

