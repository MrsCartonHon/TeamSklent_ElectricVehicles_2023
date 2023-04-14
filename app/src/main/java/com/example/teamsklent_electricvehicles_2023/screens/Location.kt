package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.runtime.getValue
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextField
import androidx.compose.ui.platform.LocalContext
import com.example.teamsklent_electricvehicles_2023.R
import com.example.teamsklent_electricvehicles_2023.Tractor
import com.example.teamsklent_electricvehicles_2023.TractorType
import com.example.teamsklent_electricvehicles_2023.TractorTypes
import com.example.teamsklent_electricvehicles_2023.ui.theme.TeamSklent_ElectricVehicles_2023Theme

@Composable
fun Location() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        InputBox("Enter Your Longitude")
    }
}