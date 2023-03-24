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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.teamsklent_electricvehicles_2023.screens.Account
import com.example.teamsklent_electricvehicles_2023.screens.Home
import com.example.teamsklent_electricvehicles_2023.screens.Login
import com.example.teamsklent_electricvehicles_2023.screens.Logs
import com.example.teamsklent_electricvehicles_2023.ui.theme.*

class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeamSklent_ElectricVehicles_2023Theme {
                MainScreen()
            }
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TeamSklent_ElectricVehicles_2023Theme {
        MainScreen()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
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
        startDestination = NavRoutes.Home.route,
    ) {

        composable(NavRoutes.Home.route) {
            Home()
        }

        composable(NavRoutes.Account.route) {
            Account()
        }

        composable(NavRoutes.Logs.route) {
            Logs()
        }
        composable(NavRoutes.Login.route){
            Login()
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


