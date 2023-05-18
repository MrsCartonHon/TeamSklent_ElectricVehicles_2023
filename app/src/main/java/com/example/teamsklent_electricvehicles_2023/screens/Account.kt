package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalView
import androidx.navigation.findNavController

@Composable
fun Account() {
    val navController = LocalView.current.findNavController()
    Column {

        Row {
            Card {
                Text(text = "Edit Account")
            }
        }
    }
}