package com.example.teamsklent_electricvehicles_2023.screens

<<<<<<< HEAD
=======
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
fun Login() {

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
            var NameIn = TextField("Enter Your Name")
            var PasswordIn = TextField("Enter Your Password")
            LoginToAccount(NameIn, PasswordIn)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(StartLabel: String): String{
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        label = { Text(text = StartLabel) },
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier.padding(horizontal = 100.dp)
    )
    return "$text"
}

@Composable
fun LoginToAccount(NameIn: String, PasswordIn: String ){
    Button(onClick = {}, modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp)) {
        Text(text = "Create")
    }
    if(NameIn != "" && PasswordIn != ""){

    }
}
>>>>>>> origin/Dom
