package com.example.teamsklent_electricvehicles_2023.screens

//<<<<<<< HEAD
//=======
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.OutlinedTextField
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
            InputBox("Enter Your Username")
            InputBox(label = "Enter Your Password")
            LogIntoAccount()
//            LoginToAccount(NameIn, PasswordIn)
        }
    }
}


@Composable
fun LoginToAccount(NameIn: String, PasswordIn: String ){
    Button(onClick = {}, modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp)) {
        Text(text = "Create")
    }
    if(NameIn != "" && PasswordIn != ""){

    }
}

@Composable
fun LogIntoAccount(){
    Button(onClick = {}, modifier = Modifier.padding(horizontal = 100.dp, vertical = 0.dp)) {
        Text(text = "Create")
    }
}
//>>>>>>> origin/Dom
