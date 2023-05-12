package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.teamsklent_electricvehicles_2023.models.*


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Employee() {

//    val nirmal = User("nirmal05", "Nirmal", "Alla", "nirmal.alla@gmail.com")
//    val jackson = User("jackson05", "Jackson", "Tagtmeier", "jakson@gmail.com")
//    val dominic = User("dominic05", "Dominic", "Halbur", "dominic.halbur@outlook.com")
//    val exampleFleet = Fleet("Fake example fleet", dominic)
//    val bhs = Location(exampleFleet, "Bettendorf High school", 41.5527552, -90.4718601)
//    val jdh = Location(exampleFleet, "JD World Headquarters", 41.476482, -90.42467)
//    val equip1 = Equipment(
//        exampleFleet, "equip1", EquipmentModel.EXC350, exampleFleet.members, bhs,
//        System.currentTimeMillis().toDouble(), 100.0, 0.0
//    )
//    val equip2 = Equipment(
//        exampleFleet, "equip2", EquipmentModel.EXC500, exampleFleet.members, bhs,
//        System.currentTimeMillis().toDouble(), 100.0, 0.0
//    )
//    val job1 = Job(exampleFleet, "BHS Courtyard", bhs, exampleFleet.members, false)
//    exampleFleet.addMember(nirmal)
//    exampleFleet.addManager(jackson)
//    exampleFleet.locations.add(bhs)
//    exampleFleet.locations.add(jdh)
//    exampleFleet.fleetEquipment.add(equip1)
//    exampleFleet.fleetEquipment.add(equip2)
//    exampleFleet.jobs.add(job1)
//
//
//    val changeMember = remember { mutableStateOf(false) }
//
//    var employeesToShow: ArrayList<User> = exampleFleet.getEmployees()
//
//    val exampleUser = User("example1234", "example", "user", "example@user.com")
//
//    var employeeToEdit = remember { mutableStateOf(exampleUser)}
//
//
//    var exampleFleetR = remember { mutableStateOf(exampleFleet) }
//
//    Column {
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Text(
//                text = "Employees",
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
//                    .align(Alignment.CenterVertically)
//            )
//        }
//        Row {
//            if (employeesToShow.isEmpty()) {
//                Text(
//                    text = "No employees have been added",
//                    fontSize = 24.sp
//                )
//            } else {
//                Column {
//                    employeesToShow.forEach { empl ->
//                        ListItem(
//                            headlineText = {
//                                Text(
//                                    text = "${empl.fName} ${empl.lName}",
//                                    fontSize = 20.sp
//                                )
//                            },
//                            trailingContent = {
//                                Text(
//                                    text = "${exampleFleet.getRole(empl)}",
//                                    fontSize = 20.sp
//                                )
//                            },
//                            modifier = Modifier.clickable(
//                                enabled = true,
//                                onClick = {
//                                    employeeToEdit.value = empl
//                                    changeMember.value = true
//                                }
//                            )
//                        )
//                    }
//                }
//            }
//        }
//    }
//
//    if (changeMember.value) {
//        var role = remember { mutableStateOf(FleetRoles.Member)}
//        role.value = exampleFleetR.value.getRole(employeeToEdit.value)!!
//        AlertDialog(
//            containerColor = MaterialTheme.colorScheme.tertiaryContainer, //
//            title = { Text(text = "Employee: ${employeeToEdit.value.fName} ${employeeToEdit.value.lName}") }, //
//            onDismissRequest = { /*TODO*/ }, //
//            text = {
//                Card(
//                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer,)
//                ) {
//                    Column() {
//                        Row() {
//                            Text(text = "Username: ${employeeToEdit.value.userName}", fontSize = 20.sp)
//                        }
//                        Row() {
//                            Text(text = "Email: ${employeeToEdit.value.email}", fontSize = 20.sp)
//                        }
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Text(text = "Owner", fontSize = 16.sp)
//                            exampleFleetR.value.getRole(employeeToEdit.value)?.let {
//                                RadioButton(
//                                    selected = it.equals(FleetRoles.Owner),
//                                    onClick = { role.value = FleetRoles.Owner },
//                                    modifier = Modifier.semantics { contentDescription = "Localized Description" },
//                                    enabled = false
//                                )
//                            }
//                        }
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Text(text = "Manager", fontSize = 16.sp)
//                            exampleFleetR.value.getRole(employeeToEdit.value)?.let {
//                                RadioButton(
//                                    selected = it.equals(FleetRoles.Manager),
//                                    onClick = {
//                                        exampleFleet.setEmployee(employeeToEdit.value, FleetRoles.Manager)
//                                        exampleFleetR.value = exampleFleet
//                                        employeeToEdit.value = exampleFleetR.value.getEmployee(employeeToEdit.value.userName)
//                                        role.value = FleetRoles.Manager
//                                    },
//                                    modifier = Modifier.semantics { contentDescription = "Localized Description" },
//                                    enabled = true
//                                )
//                            }
//                        }
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Text(text = "Member", fontSize = 16.sp)
//                            exampleFleetR.value.getRole(employeeToEdit.value)?.let {
//                                RadioButton(
//                                    selected = it.equals(FleetRoles.Member),
//                                    onClick = {
//                                        exampleFleet.setEmployee(employeeToEdit.value, FleetRoles.Member)
//                                        exampleFleetR.value = exampleFleet
//                                        employeeToEdit.value = exampleFleetR.value.getEmployee(employeeToEdit.value.userName)
//                                        role.value = FleetRoles.Member
//                                    },
//                                    modifier = Modifier.semantics { contentDescription = "Localized Description" },
//                                    enabled = true
//                                )
//                            }
//                        }
//                    }
//                }
//            },
//            confirmButton = {
//                TextButton(
//                    onClick = {
//                        changeMember.value = false
//                    }
//                ) { Text(text = "Done") }
//            },
//            dismissButton = {
//                TextButton(
//                    onClick = {
//                        changeMember.value = false
//                    }
//                ) { Text(text = "Cancel") }
//            }
//        )
//    }
}

fun editUser(){

}