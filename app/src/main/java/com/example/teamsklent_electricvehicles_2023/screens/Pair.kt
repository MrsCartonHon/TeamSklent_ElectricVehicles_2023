package com.example.teamsklent_electricvehicles_2023.screens

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import com.example.teamsklent_electricvehicles_2023.R
import com.example.teamsklent_electricvehicles_2023.Tractor
import com.example.teamsklent_electricvehicles_2023.TractorType
import com.example.teamsklent_electricvehicles_2023.TractorTypes
import com.example.teamsklent_electricvehicles_2023.ui.theme.TeamSklent_ElectricVehicles_2023Theme

@Composable
fun Pair(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Dropdown()
    }
}


@Composable
fun Dropdown(){
    InputBox(label = "Name of Tractor")
    InputBox(label = "Tractor Type")

    Button(
        onClick = { /*Add in pairing function*/ },
        contentPadding = PaddingValues(all=10.dp)
    ) {
        Text(text="Pair")
    }
}






