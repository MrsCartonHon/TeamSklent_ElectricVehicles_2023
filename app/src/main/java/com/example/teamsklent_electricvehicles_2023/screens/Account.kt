package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.NavRoutes
import com.example.teamsklent_electricvehicles_2023.ui.theme.Typography

@Composable
fun Account(navController: NavHostController) {

    Button(onClick = {navController.navigate(NavRoutes.Login.route)}) {
        Text(
            text = "Login",
            color = Color.Blue,
            style = Typography.bodyLarge
        )
    }
    Column {
        Text(text = "Fleets")

        Row(content = {
            Text(text = "Commercial Mode")
            RadioButton(selected = false, onClick = { /*TODO Turn on commercial mode*/ })
        })

        Divider()

        Text( text = "Edit Account")
    }
}