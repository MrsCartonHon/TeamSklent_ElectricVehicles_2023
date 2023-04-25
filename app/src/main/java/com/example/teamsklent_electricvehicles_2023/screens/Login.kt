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
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.NavRoutes
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController) {


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
            //Image(painter = painterResource(id = R.mipmap.ic_launcher), contentDescription = "JDConnect Logo")

            Text(
                text = "Login To Account",
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

            Button(
                onClick = {
                    if(!email.equals("") && !password.equals("")){
                        //login(email.text, password.text)
                        navController.navigate(NavRoutes.Home.route)
                    }
                },
                modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp)) {
                Text(text = "Login")
            }
            TextButton(
                onClick = { navController.navigate(NavRoutes.Signup.route) },
                content = { Text(text = "Don't have an account? Sign Up!")}
            )
        }
    }
}

fun login(email: String, password: String) {
    val localAuth = Firebase.auth

    localAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                /*TODO return to home page*/

            } else {
                // maybe they don't have an account??
                /*TODO alert they don't have an account*/
            }
        }
}