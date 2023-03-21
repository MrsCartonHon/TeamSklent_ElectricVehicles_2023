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

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun Signup() {

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
            InputBox(label = "Enter Your Name")
            InputBox(label = "Enter Your Password")
            InputBox(label = "Confirm Password")
            CreateAccount()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBox(label: String){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "$label") },
        onValueChange = {
            text = it
        },
        modifier = Modifier.padding(horizontal = 100.dp)
    )
}

@Composable
fun CreateAccount(){
    Button(onClick = {}, modifier = Modifier.padding(horizontal = 100.dp, vertical = 0.dp)) {
        Text(text = "Create")
    }
}


