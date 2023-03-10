package com.example.teamsklent_electricvehicles_2023

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

object TractorTypes {
    val Tractors = listOf(
        TractorType(
            name = "X200-EV",
            icon = Icons.Filled.Home,
            capacity = 200.0
        ),
        TractorType(
            name = "X250-EV",
            icon = Icons.Filled.Home,
            capacity = 250.0
        ),
        TractorType(
            name = "X300-EV",
            icon = Icons.Filled.Home,
            capacity = 300.0
        ),
        TractorType(
            name = "X350-EV",
            icon = Icons.Filled.Home,
            capacity = 350.0
        )
    )
}