package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.NavRoutes
import com.example.teamsklent_electricvehicles_2023.R
import com.example.teamsklent_electricvehicles_2023.database.USER_MANAGMENT
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            IconButton(
                onClick = {/*TODO*/ }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.account_edit),
                    contentDescription = "Edit Account"
                )
            }
        }
        Row {
            Card(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp)
            ) {
                Text(
                    text = "Fleets",
                    modifier = Modifier.absolutePadding(10.dp, 0.dp, 0.dp, 0.dp),
                    fontSize = 20.sp
                )
                Row {
                    Text(
                        text = "Commercial Mode",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    RadioButton(
                        selected = false,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { /*TODO Turn on commercial mode*/ }
                    )
                }
            }
        }
        Row {
            Card(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text = "My Fleets",
                            modifier = Modifier
                                .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
                                .align(Alignment.CenterStart),
                            fontSize = 24.sp
                        )
                        TextButton(
                            onClick = {navController.navigate(NavRoutes.NewFleet.route)},
                            modifier = Modifier.align(Alignment.CenterEnd)
                        ) {
                            Text(
                                text = "Create New Fleet",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                ) {
                    Card(
                        modifier = Modifier
                            .absolutePadding(10.dp, 10.dp, 0.dp, 0.dp)
                    ) {
                        val crntUsr = USER_MANAGMENT().getUser(Firebase.auth.currentUser!!.uid)
                        if (!crntUsr?.ownedFleets!!.isEmpty()){
                            crntUsr?.ownedFleets.forEach{ fleet ->
                                ListItem(
                                    headlineText = {
                                        Text(text = fleet.name, fontSize = 20.sp)
                                    }
                                )
                            }
                        }else{
                            Text(
                                text = "No Fleets Have Been Created",
                                fontSize = 20.sp,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }

                    }
                }
                /* TODO write a list of a users owner fleets if there arent any say "No Fleets Created" add a button to create a new fleet */
                
            }
        }
    }
}

@Composable
fun settingsCard(){

}