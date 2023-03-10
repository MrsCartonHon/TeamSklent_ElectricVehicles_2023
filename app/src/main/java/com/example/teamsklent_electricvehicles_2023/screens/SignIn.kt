package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.teamsklent_electricvehicles_2023.ui.theme.TeamSklent_ElectricVehicles_2023Theme
import com.example.teamsklent_electricvehicles_2023.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label : String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) }
    )
}

@Composable
fun ButtonWithElevation() {
    Button(onClick = {

    },elevation =  ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    )) {
        Text(text = "Continue")
    }
}

@Composable
fun SignIn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp)
    ) {
        Spacer(modifier = Modifier.padding(vertical = 50.dp))

        Image(
            painter = painterResource(id = R.drawable.deere_logo),
            contentDescription = stringResource(id = R.string.deere_logo),
        )

        Spacer(modifier = Modifier.padding(vertical = 50.dp))

        Text(text = "Login", fontSize = 5.em, fontWeight = FontWeight.Bold)

        InputField("Username")
        InputField("Password")
        
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        
        ButtonWithElevation()
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    TeamSklent_ElectricVehicles_2023Theme {
        SignIn()
    }
}