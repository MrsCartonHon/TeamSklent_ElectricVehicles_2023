package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Home() {

    Column {

    }
}

fun getWeather(val lat, val lon){

    // Get your IP asynchronously
    get(url = "https://api.weather.gov/points/${lat},${lon}")
        .subscribe { response : Response ->
            val ipAddress = response.jsonObject.getString("origin")
        }
}