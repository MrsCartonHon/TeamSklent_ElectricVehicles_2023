package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun JoinFleet (){
    var code by remember { mutableStateOf(TextFieldValue("")) }
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        text = {
            OutlinedTextField(
                value = code,
                onValueChange = {
                    code = it
                },
                modifier = Modifier.padding(horizontal = 100.dp)
            )
        },
        confirmButton = {

        },
        dismissButton = {

        }
    )
}