package com.example.teamsklent_electricvehicles_2023.screens

import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.teamsklent_electricvehicles_2023.NavRoutes
import com.example.teamsklent_electricvehicles_2023.database.USER_MANAGMENT
import com.example.teamsklent_electricvehicles_2023.models.User
import com.example.teamsklent_electricvehicles_2023.ui.theme.JDBlack
import com.example.teamsklent_electricvehicles_2023.ui.theme.JDGreen1
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Signup() {
    val navController = LocalView.current.findNavController()

    var fname by remember { mutableStateOf(TextFieldValue("")) }
    var lname by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordConfirm by remember { mutableStateOf(TextFieldValue("")) }

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
                text = "Create Your Account",
                style = TextStyle(
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(vertical = 10.dp),
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = fname,
                label = { Text(text = "First Name") },
                onValueChange = {
                    fname = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )
            OutlinedTextField(
                value = lname,
                label = { Text(text = "Last Name") },
                onValueChange = {
                    lname = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )
            OutlinedTextField(
                value = email,
                label = { Text(text = "Email") },
                onValueChange = {
                    email = it
                    /* TODO validate email and check if its already in use */
                },
                modifier = Modifier.padding(horizontal = 100.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            OutlinedTextField(
                value = password,
                label = { Text(text = "Password") },
                onValueChange = {
                    password = it
                },
                modifier = Modifier.padding(horizontal = 100.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            OutlinedTextField(
                value = passwordConfirm,
                label = { Text(text = "Confirm Password") },
                onValueChange = {
                    passwordConfirm = it
                    /* TODO alert if passwords don't match */
                },
                modifier = Modifier.padding(horizontal = 100.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(
                onClick = {
                    if (password.text == passwordConfirm.text) {
                        register(fname.text,lname.text,email.text,password.text,navController)
                    } else {
                        // passwords don't match display error
                    }

                },
                modifier = Modifier.padding(horizontal = 100.dp, vertical = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = JDGreen1, contentColor = JDBlack)
                ) {
                Text(text = "Register")
            }
        }
    }
}
fun register(fname: String, lname: String, email : String, password : String, navController:NavController) {
    val auth = Firebase.auth

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser?.uid
                Log.d("uid", user.toString())
                val newUser: User = User(
                    user.toString(),
                    fname,
                    lname,
                    email,
                    ArrayList(),
                    ArrayList(),
                    ArrayList()
                )
                USER_MANAGMENT().writeUser(newUser)
                navController.navigate(NavRoutes.Home.route)
            }
        }

}