package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamsklent_electricvehicles_2023.database.FLEET_MANAGMENT
import com.example.teamsklent_electricvehicles_2023.models.User

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NewFleet(){


    var name by remember { mutableStateOf(TextFieldValue("")) }
    var managers: ArrayList<User> = ArrayList()
    var members: ArrayList<User> = ArrayList()

    val openDialog = remember { mutableStateOf(false)  }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Row{
                Text(
                    text = "Create Your Fleet",
                    style = TextStyle(
                        fontSize = 24.sp
                    ),
                    modifier = Modifier.padding(vertical = 10.dp),
                    textAlign = TextAlign.Center,
                )
            }
            Row{
                OutlinedTextField(
                    label = { Text(text = "Company Name") },
                    value = name,
                    onValueChange = {
                        name = it
                        if(FLEET_MANAGMENT().isNameTaken(name.text)){
                            /*TODO alert the name is already taken*/

                        }
                    },
                    modifier = Modifier.padding(horizontal = 100.dp)
                )
            }
            Row{
                Button(
                    onClick = {
                        /* TODO alert the name is already taken */
                    },
                    modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp),

                    ){
                    Text(text = "Create Fleet")
                }
            }

        }
    }
    if(openDialog.value){
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                openDialog.value = false
            },
            title = {
                Text(text = "Name Taken Already")
            },
            text = {
                Text("A company with the name $name already exists. Please pick a different name.")
            },
            dismissButton = {
                Button(

                    onClick = {
                        openDialog.value = false
                    }) {
                    Text("Close")
                }
            },
            confirmButton = {

            }
        )
    }
}