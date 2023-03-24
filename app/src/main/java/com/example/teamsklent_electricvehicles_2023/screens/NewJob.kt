@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.teamsklent_electricvehicles_2023.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamsklent_electricvehicles_2023.ExampleUsers
import com.example.teamsklent_electricvehicles_2023.ListItem
import com.example.teamsklent_electricvehicles_2023.User
import com.example.teamsklent_electricvehicles_2023.database.Fleet
import com.example.teamsklent_electricvehicles_2023.database.Fleet.Job


fun numOfEmployees(items: List<ListItem>): Int {
    var count = 0
    items.forEach {
        if (it.isSelected) {
            count++
        }
    }
    return count
}
@JvmName("numOfEmployees1")
fun numOfEmployees(items: List<User>): Int {
    return items.size
}


fun selectedEmployees(items: List<ListItem>, users: List<User>): ArrayList<User> {
    val selected = ArrayList<User>()
    items.forEach { it ->
        if (it.isSelected) {
            val name = it.title
            users.forEach {
                if (it.username == name) {
                    selected.add(it)
                }
            }
        }
    }
    return selected
}

fun createJob(jobName: String, jobLocation: String, employees: List<User>): Job {
    return Job(
        jobName = jobName,
        location = Fleet.Location(jobLocation, 1.0, 1.0),
        employees = employees,
        completed = false
    )
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3Api
//@Preview
@Composable
fun NewJob() {

    // Data fields
    val USERSOURCE = ExampleUsers.users

    var jobName by rememberSaveable { mutableStateOf("") } // Name of the job
    var jobLocation by rememberSaveable { mutableStateOf("") } // Location of the job


    val openDialog = remember { mutableStateOf(false) } // Is the employee dialog open
    var buttonText by remember { mutableStateOf("Select Employees") }


    var items by remember { // Employees
        mutableStateOf(
            USERSOURCE.map {
                ListItem(
                    title = it.username,
                    isSelected = false
                )
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        TextField( // Job name input
            value = jobName,
            onValueChange = {
                jobName = it
            },
            label = { Text("Name of Job") },
            placeholder = { Text("Name") }
        )

        TextField( // location input
            value = jobLocation,
            onValueChange = {
                jobLocation = it
            },
            label = { Text("Job location") },
            placeholder = { Text("Location") }
        )

        Button( // Employee selector
            onClick = {
                openDialog.value = openDialog.value.not()
            },
            content = { Text(buttonText) }
        )
        if (openDialog.value) {
            AlertDialog( // Employee selector dialog
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                title = { Text(text = "Select Employees") },
                onDismissRequest = { /*TODO*/ },
                text = {
                    LazyColumn(){
                        items(items.size) { i ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        items = items.mapIndexed { j, item ->
                                            if (i == j) {
                                                item.copy(isSelected = !item.isSelected)
                                            } else item
                                        }
                                    }
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = items[i].title)
                                if (items[i].isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Selected",
                                        tint = Color.Green,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            buttonText = "${numOfEmployees(items)} Employees Selected"
                            openDialog.value = false
                        }
                    ) { Text(text = "Done") }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) { Text(text = "Cancel") }
                }
            )
        }

        TextButton( // Save button
            onClick = {
                if (jobName != "" && jobLocation != "" && numOfEmployees(items) != 0) {
                    createJob(jobName, jobLocation, selectedEmployees(items, USERSOURCE))
                }
            }
        ) { Text(text = "Create Job") }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NewLocation() {
    var newLocationName by rememberSaveable { mutableStateOf("") } // Name of the new location
    var newLocationLatString by rememberSaveable { mutableStateOf("") } // String form of new Latitude
    var newLocationLat: Double = 0.0
    var newLocationLonString by rememberSaveable { mutableStateOf("") } // String form of new Longitude
    var newLocationLon: Double = 0.0

    AlertDialog( // New location dialog
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        title = { Text(text = "New Location") },
        onDismissRequest = { /*TODO*/ },
        text = {
            Column(
                modifier = Modifier
            ) {
                TextField(
                    label = { Text("Name of Location") },
                    placeholder = { Text("Name") },
                    value = newLocationName,
                    onValueChange = {
                        newLocationName = it
                    }
                )
                TextField( // Latitude input
                    label = { Text("Latitude of Location") },
                    placeholder = { Text("Latitude") },
                    value = newLocationLatString,
                    onValueChange = { text ->
                        newLocationLat = text.toDouble()
                    },
                    keyboardOptions = KeyboardOptions.Default.copy( // Only allow number input
                        keyboardType = KeyboardType.NumberPassword
                    ),
                    visualTransformation = VisualTransformation.None
                )
                TextField( // Longitude input
                    label = { Text("Longitude of Location") },
                    placeholder = { Text("Longitude") },
                    value = newLocationLonString,
                    onValueChange = { text ->
                        newLocationLon = text.toDouble()
                    },
                    keyboardOptions = KeyboardOptions.Default.copy( // Only allow number input
                        keyboardType = KeyboardType.NumberPassword
                    ),
                    visualTransformation = VisualTransformation.None
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    Fleet.Location(newLocationName, newLocationLat, newLocationLon)
                }
            ) { Text(text = "Create") }
        },
        dismissButton = {
            TextButton(
                onClick = {

                }
            ) { Text(text = "Cancel") }
        }
    )
}

//@Composable
//fun TimeDialog(){
//    TimePickerDialog(){
//
//    }
//}