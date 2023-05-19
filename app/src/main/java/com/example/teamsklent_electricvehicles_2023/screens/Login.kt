package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.teamsklent_electricvehicles_2023.NavRoutes
import com.example.teamsklent_electricvehicles_2023.ui.theme.JDGreen1
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Login() {
   // val navController = LocalView.current.findNavController()
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        keyboardController?.hide()
                    })
                }
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
                modifier = Modifier.padding(horizontal = 100.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            var passwordVisible by rememberSaveable { mutableStateOf(false) }

            OutlinedTextField(
                label = { Text(text = "Password") },
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier.padding(horizontal = 100.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}){
                        Icon(imageVector = image, description)
                    }
                }
            )

            Button(
                onClick = {
                    if(!email.equals("") && !password.equals("")){
                        //login(email.text, password.text)

                    }
                },
                modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = JDGreen1)
            ) {
                Text(text = "Login")
            }
            TextButton(
                onClick = { /*navController.navigate(NavRoutes.Signup.route)*/ },
                content = { Text(text = "Don't have an account? Sign Up!")}
            )
        }
    }
}
fun login(email: String, password: String, navController: NavController) {
    val localAuth = Firebase.auth
    localAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate(NavRoutes.Home.route)
            } else {
                // maybe they don't have an account??
                /*TODO alert they don't have an account*/
            }
        }
}