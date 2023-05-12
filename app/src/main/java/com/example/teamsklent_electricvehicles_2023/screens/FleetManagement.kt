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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamsklent_electricvehicles_2023.R
import com.example.teamsklent_electricvehicles_2023.models.*


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FleetManagement() {
    val openRemoveUser = remember { mutableStateOf(false) } // Is the dialog open

    var jobName = remember { mutableStateOf("") }
    var lat = remember { mutableStateOf(0.0) }
    var lon = remember { mutableStateOf(0.0) }



    /*TODO add tabs for overview, jobs,and people */


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
                if (exampleFleet.fleetEquipment.isEmpty()) {
                    Text(
                        text = "No Equipment has been added",
                        fontSize = 24.sp
                    )
                } else {
                    exampleFleet.fleetEquipment.forEach {
                        Card(
                            modifier = Modifier.absolutePadding(10.dp, 10.dp, 10.dp, 10.dp)
                        ) {
                            ListItem(
                                headlineContent = {
                                    Text(
                                        text = "${it.model}",
                                        fontSize = 20.sp
                                    )
                                },
                                supportingContent = {
                                    Text(
                                        text = "${it.remainingCapacity / it.totalCapacity}%",
                                        fontSize = 16.sp
                                    )
                                },
                                trailingContent = { Text(text = it.location.name) }
                            )
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
                if (exampleFleet.jobs.isEmpty()) {
                    Text(
                        text = "No Jobs have been created",
                        fontSize = 24.sp
                    )
                } else {
                    exampleFleet.jobs.forEach { job ->
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