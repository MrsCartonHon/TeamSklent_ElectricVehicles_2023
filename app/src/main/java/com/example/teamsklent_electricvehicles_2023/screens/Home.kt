package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.models.Fleet
import com.fasterxml.jackson.databind.ObjectMapper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, ) {

    Column {

    }
}



fun toJSON(fleet: Fleet): String {
    val mapper = ObjectMapper()
    val json: String = mapper.writeValueAsString(fleet)
    return json
}
