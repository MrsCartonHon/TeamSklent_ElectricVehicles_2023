@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.R
import com.example.teamsklent_electricvehicles_2023.models.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FleetManagement(navController: NavHostController, fleet: Fleet) {
    val openRemoveUser = remember { mutableStateOf(false) } // Is the dialog open

    var jobName = remember { mutableStateOf("") }
    var lat = remember { mutableStateOf(0.0) }
    var lon = remember { mutableStateOf(0.0) }



    /*TODO add tabs for overview, jobs,and people */


//

    Column {

        // List of Fleet Equipment
        Row(
            modifier = Modifier.absolutePadding(5.dp, 5.dp, 5.dp, 5.dp)
        ) {
            Card(
                onClick = { /* Do Nothing */ },
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Equipment",
                        fontSize = 24.sp,
                        modifier = Modifier.absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
                    )

                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.wrapContentWidth(Alignment.End)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = android.R.drawable.ic_menu_add),
                            contentDescription = "Add Equipment"
                        )
                    }
                }
                if (fleet.fleetEquipment.isEmpty()) {
                    Text(
                        text = "No Equipment has been added",
                        fontSize = 24.sp
                    )
                } else {
                    fleet.fleetEquipment.forEach {
                        Card(
                            modifier = Modifier.absolutePadding(10.dp, 10.dp, 10.dp, 10.dp)
                        ) {
                            /*ListItem(
                                headlineText = {
                                    Text(
                                        text = "${it.model}",
                                        fontSize = 20.sp
                                    )
                                },
                                supportingText = {
                                    Text(
                                        text = "${it.remainingCapacity / it.totalCapacity}%",
                                        fontSize = 16.sp
                                    )
                                },
                                trailingContent = { Text(text = it.location.name) }
                            )*/
                        }
                    }
                }
            }
        }
        Divider()
        // List of Fleet Jobs
        Row(
            modifier = Modifier.absolutePadding(5.dp, 5.dp, 5.dp, 5.dp)
        ) {
            Card(
                onClick = {/*Do nothing*/ },
                shape = MaterialTheme.shapes.medium
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Jobs",
                        fontSize = 24.sp,
                        modifier = Modifier.absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
                    )
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.wrapContentWidth(Alignment.End)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_add_24),
                            contentDescription = "Add Equipment"
                        )
                    }
                }
                if (fleet.jobs.isEmpty()) {
                    Text(
                        text = "No Jobs have been created",
                        fontSize = 24.sp
                    )
                } else {
                    fleet.jobs.forEach { job ->
                        val isCompleted = remember { mutableStateOf(job.completed) }
                        Card(
                            modifier = Modifier.absolutePadding(10.dp, 10.dp, 10.dp, 10.dp)
                        ) {
                            ListItem(
                                headlineText = {
                                    Text(
                                        text = job.jobName,
                                        fontSize = 20.sp
                                    )
                                },
                                supportingText = {
                                    Text(
                                        text = job.location.name,
                                        fontSize = 16.sp
                                    )
                                },
                                trailingContent = {
                                    Checkbox(checked = isCompleted.value,
                                        onCheckedChange = {
                                            isCompleted.value = it
                                            job.completed = it
                                        }
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
//    if (openRemoveUser.value) {
//        AlertDialog(
//            containerColor = MaterialTheme.colorScheme.tertiaryContainer, //
//            title = { Text(text = "Select Employees") }, //
//            onDismissRequest = { /*TODO*/ }, //
//            text = {
//                LazyColumn(
//                    modifier = Modifier
//                        .fillMaxSize()
//                ) {
//
//                }
//            },
//            confirmButton = {
//                TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Done") }
//            },
//            dismissButton = {
//                TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Cancel") }
//            }
//        )
//    }
}

fun newJob(){

}