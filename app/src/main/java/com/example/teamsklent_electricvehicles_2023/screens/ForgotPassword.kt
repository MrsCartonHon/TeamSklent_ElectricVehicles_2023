package com.example.teamsklent_electricvehicles_2023.screens

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPassword(){

    var email by remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            /* TODO Add John Deere Logo */

            Text(
                text = "Forgot your password?",
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

            Button(
                onClick = {
                    if (!email.equals("")) {
                        Firebase.auth.sendPasswordResetEmail(email.toString());
                    }
                },
                modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp)) {
                Text(text = "Send Email")
            }
        }
    }
}