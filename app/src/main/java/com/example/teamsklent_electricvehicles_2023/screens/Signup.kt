package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

fun register(name : String, email : String, password : String) {
    val auth = Firebase.auth

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {

            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Signup() {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordConfirm by remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //TODO Add John Deere Logo

            Text(
                text = "Create Your Account",
                style = TextStyle(
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(vertical = 10.dp),
                textAlign = TextAlign.Center
            )


            OutlinedTextField(
                value = name,
                label = { Text(text = "Name") },
                onValueChange = {
                    name = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )
            OutlinedTextField(
                value = email,
                label = { Text(text = "Email") },
                onValueChange = {
                    email = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )
            OutlinedTextField(
                value = password,
                label = { Text(text = "Password") },
                onValueChange = {
                    password = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )
            OutlinedTextField(
                value = passwordConfirm,
                label = { Text(text = "Confirm Password") },
                onValueChange = {
                    passwordConfirm = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )

            Button(onClick = {
                if (password.text == passwordConfirm.text) {
                    register(name.text, email.text, password.text)
                } else {
                    // passwords don't match display error
                }

            }, modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp)) {
                Text(text = "Register")
            }
        }
    }
}