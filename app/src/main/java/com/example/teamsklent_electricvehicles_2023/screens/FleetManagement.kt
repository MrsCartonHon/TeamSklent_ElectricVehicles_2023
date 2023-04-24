package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamsklent_electricvehicles_2023.models.*


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FleetManagement() {
    val openRemoveUser = remember { mutableStateOf(false) } // Is the dialog open

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


    Column(content = {

        Row(content = {
            Card(
                onClick = { /* Do Nothing */ },
                shape = MaterialTheme.shapes.medium,
                content = {
                    Row(
                        content = {
                            Text(text = "Equipment", fontSize = 24.sp, modifier = Modifier.absolutePadding(10.dp,0.dp,0.dp,0.dp))
                        }
                    )
                    if (exampleFleet.fleetEquipment.isEmpty()) {
                        Text(
                            text = "No Equipment has been added",
                            fontSize = 24.sp
                        )
                    } else {
                        exampleFleet.fleetEquipment.forEach {
                            Card(
                                modifier = Modifier.absolutePadding(10.dp, 10.dp, 10.dp, 10.dp),
                                content = {
                                    ListItem(
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
                                        trailingContent = { Text(text = "${it.location.name}") }
                                    )
                                }
                            )
                        }
                    }
                }
            )
        })

        Divider()

        Row(content = {
            Card(
                onClick = {/*Do nothing*/ },
                shape = MaterialTheme.shapes.medium,
                content = {
                    Row(
                        content = {
                            Text(text = "Jobs", fontSize = 24.sp, modifier = Modifier.absolutePadding(10.dp,0.dp,0.dp,0.dp))
                        }
                    )
                    if (exampleFleet.jobs.isEmpty()) {
                        Text(
                            text = "No Jobs have been completed",
                            fontSize = 24.sp
                        )
                    } else {
                        exampleFleet.jobs.forEach { job ->
                            val isCompleted = remember { mutableStateOf(job.completed) }
                            Card(
                                modifier = Modifier.absolutePadding(10.dp, 10.dp, 10.dp, 10.dp),
                                content = {
                                    ListItem(
                                        headlineText = {
                                            Text(
                                                text = "${job.jobName}",
                                                fontSize = 20.sp
                                            )
                                        },
                                        supportingText = {
                                            Text(
                                                text = "${job.location.name}",
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
                            )
                        }
                    }
                }
            )
        })

        Row(content = {
            Card(
                onClick = {/*Do nothing*/ },
                shape = MaterialTheme.shapes.medium,
                content = {
                    Row(
                        content = {
                            Text(text = "Jobs", fontSize = 24.sp, modifier = Modifier.absolutePadding(10.dp,0.dp,0.dp,0.dp))
                        }
                    )
                    if (exampleFleet.jobs.isEmpty()) {
                        Text(
                            text = "No Jobs have been completed",
                            fontSize = 24.sp
                        )
                    } else {
                        exampleFleet.jobs.forEach { job ->
                            val isCompleted = remember { mutableStateOf(job.completed) }
                            Card(
                                modifier = Modifier.absolutePadding(10.dp, 10.dp, 10.dp, 10.dp),
                                content = {
                                    ListItem(
                                        headlineText = {
                                            Text(
                                                text = "${job.jobName}",
                                                fontSize = 20.sp
                                            )
                                        },
                                        supportingText = {
                                            Text(
                                                text = "${job.location.name}",
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
                            )
                        }
                    }
                }
            )
        })
    })






    if (openRemoveUser.value) {
        AlertDialog(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer, //
            title = { Text(text = "Select Employees") }, //
            onDismissRequest = { /*TODO*/ }, //
            text = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                }
            },
            confirmButton = {
                TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Done") }
            },
            dismissButton = {
                TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Cancel") }
            }
        )
    }
}