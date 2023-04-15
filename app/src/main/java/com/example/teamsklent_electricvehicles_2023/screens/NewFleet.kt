package com.example.teamsklent_electricvehicles_2023.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.teamsklent_electricvehicles_2023.DominicUser
import com.example.teamsklent_electricvehicles_2023.database.Fleet
import com.example.teamsklent_electricvehicles_2023.models.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NewFleet(){

    var database: DatabaseReference = Firebase.database.getReferenceFromUrl("https://jdconnect-45f8d-default-rtdb.firebaseio.com/")


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
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Create Your Account",
                style = TextStyle(
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(vertical = 10.dp),
                textAlign = TextAlign.Center,
            )
            OutlinedTextField(
                label = { Text(text = "Company Name") },
                value = name,
                onValueChange = {
                    name = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )



            Button(
                onClick = {
                    Log.i("firebase"," ${database.child("fleets").get()} exists")

                    database.child("fleets").child(name.toString()).get().addOnSuccessListener {
                        Log.i("firebase", "Got value ${it.value}")
                    }.addOnFailureListener{
                        Log.e("firebase", "Error getting data", it)
                        val newFleet = Fleet(name.toString(),DominicUser.dominic)
                        database.child("fleets").child(name.toString()).setValue(Gson().toJson(this))
                    }
                },
                modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp)) {
                Text(text = "Create Company")
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
            confirmButton = {}
        )
    }
}