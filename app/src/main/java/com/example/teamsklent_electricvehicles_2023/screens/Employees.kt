package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun Employee() {

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


    val sortMenu = remember { mutableStateOf(false) }

    var employeesToShow = remember { mutableListOf<User>() }

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Employees",
                fontSize = 24.sp,
                modifier = Modifier.absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
            )
            IconButton(
                onClick = { sortMenu.value = sortMenu.value.not() },
                modifier = Modifier.absolutePadding(0.dp, 0.dp, 10.dp, 0.dp),
                content = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_sort_24),
                        contentDescription = "sort"
                    )
                }
            )
        }
        Row {
            if (employeesToShow.isEmpty()) {
                Text(
                    text = "No Jobs have been completed",
                    fontSize = 24.sp
                )
            } else {
                Column(content = {
                    employeesToShow.forEach { empl ->

                        ListItem(
                            headlineText = {
                                Text(
                                    text = "${empl.fName} ${empl.lName}",
                                    fontSize = 20.sp
                                )
                            },
                            trailingContent = {
                                Text(
                                    text = "${exampleFleet.getRole(empl)}",
                                    fontSize = 20.sp
                                )
                            }
                        )
                    }
                })
            }
        }
    }

    // The sort menu
    DropdownMenu(
        expanded = sortMenu.value,
        onDismissRequest = { sortMenu.value = false }
    ) {
        DropdownMenuItem(
            text = { Text("All") },
            onClick = { employeesToShow = exampleFleet.getEmployees() },
        )
        DropdownMenuItem(
            text = { Text("Managers") },
            onClick = { employeesToShow = exampleFleet.managers() },
        )
        Divider()
        DropdownMenuItem(
            text = { Text("Members") },
            onClick = { employeesToShow = exampleFleet.members() },
        )
    }


}