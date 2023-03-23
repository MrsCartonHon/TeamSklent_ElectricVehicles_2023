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
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Login() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

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
                label = { Text(text = "Email") },
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )

            OutlinedTextField(
                label = { Text(text = "Password") },
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )

            Button(onClick = { login(email.text, password.text) }, modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp)) {
                Text(text = "Login")
            }
        }
    }
}

fun login(email: String, password: String) {
    val auth = Firebase.auth

    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // return to home page
            } else {
                // maybe they dont have an account??
            }
        }
}