@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamsklent_electricvehicles_2023.ExampleUsers
import com.example.teamsklent_electricvehicles_2023.ListItem


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NewJob(){
    // Data from databases
    //var members = ExampleUsers.users

    // Data fields
    var jobName by rememberSaveable { mutableStateOf("") } //Name of the job


    var items by remember {
        mutableStateOf(
            ExampleUsers.users.map {
               ListItem(
                    title = it.username,
                    isSelected = false
                )
            }
        )
    }

    var openDialog = remember{mutableStateOf(false)} // Is the dialog open

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = jobName,
            onValueChange = {
                jobName = it
            },
            label = { Text("Name of Job") },
            placeholder = { Text("Name") }
        )

        Button(
            onClick = {
                openDialog.value = openDialog.value.not()
            },
            content = { Text("Employees") },
            modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(10.dp, 350.dp, 10.dp, 350.dp)
        )

        if(openDialog.value){
            AlertDialog(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                title = {Text(text = "Select Employees")},
                onDismissRequest = { /*TODO*/ },
                text = {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
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
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = { openDialog.value = false }) { Text(text = "Done") }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog.value = false }) { Text(text = "Cancel") }
                }
            )
        }
    }
}