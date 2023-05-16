@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewJob(navController: NavHostController, auth: FirebaseAuth?, fleetName: String?){
    // Data from databases
    //var members = ExampleUsers.users

    // Data fields
    var jobName by rememberSaveable { mutableStateOf("") } //Name of the job

    var items by remember {
        mutableStateOf(
//            /*TODO replace ExampleUsers with source of actual users*/

//        )
    }


//    var items by remember {
//        mutableStateOf(
//            /*TODO replace ExampleUsers with source of actual users*/
//            ExampleUsers.users.map {
//               ListItem(
//                    title = it.username,
//                    isSelected = false
//                )
//            }
//        )
//    }
//
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