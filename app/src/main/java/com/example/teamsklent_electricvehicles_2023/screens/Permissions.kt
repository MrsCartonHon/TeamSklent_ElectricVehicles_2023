package com.example.teamsklent_electricvehicles_2023.screens

import android.view.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun requestPermissions(): Boolean{
    val openDialog = remember { mutableStateOf(true) }
    var response = false

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Location Permissions")
            },
            text = {
                Text(
                    text = "This app requires the use of location services. Do you permit us to access your location"
                )
            },
            dismissButton = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text("Dismiss")
                    }
                }
            },
            confirmButton = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            openDialog.value = false
                            response = true
                        }
                    ){
                        Text(text = "Allow")
                    }
                }
            }
        )
    }

    return response
}