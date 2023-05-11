@file:OptIn(ExperimentalMaterial3Api::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.teamsklent_electricvehicles_2023

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.teamsklent_electricvehicles_2023.database.FLEET_MANAGMENT
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

    val nirmal = User("nirmal05", "Nirmal", "Alla", "nirmal.alla@gmail.com")
    val jackson = User("jackson05", "Jackson", "Tagtmeier", "jakson@gmail.com")
    val dominic = User("dominic05", "Dominic", "Halbur", "dominic.halbur@outlook.com")
    val exampleFleet = Fleet("Fake example fleet", dominic)
    val bhs = Location(exampleFleet, "Bettendorf High school", 41.5527552, -90.4718601)
    val jdh = Location(exampleFleet, "JD World Headquarters", 41.476482, -90.42467)
    val equip1 = Equipment(
        exampleFleet, "equip1", EquipmentModel.EXC350, exampleFleet.members, bhs,
        System.currentTimeMillis().toDouble(), 100.0, 0.0
    )
    val equip2 = Equipment(
        exampleFleet, "equip2", EquipmentModel.EXC500, exampleFleet.members, bhs,
        System.currentTimeMillis().toDouble(), 100.0, 0.0
    )

    val job1 = Job(exampleFleet, "BHS Courtyard", bhs, exampleFleet.members, false)
    exampleFleet.addMember(nirmal)
    exampleFleet.addManager(jackson)
    exampleFleet.locations.add(bhs)
    exampleFleet.locations.add(jdh)
    exampleFleet.fleetEquipment.add(equip1)
    exampleFleet.fleetEquipment.add(equip2)
    exampleFleet.jobs.add(job1)

    Log.e("FIREBASE", FLEET_MANAGMENT().writeFleet(exampleFleet).toString())




    Scaffold(
        //topBar = { TopAppBar(title = { Text("Bottom Navigation Demo") }) },
        content = { NavigationHost(navController = navController) },
        bottomBar = {
            if(auth != null) {
                BottomNavigationBar(navController = navController)
            }
        }
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


