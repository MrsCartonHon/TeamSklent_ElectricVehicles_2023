package com.example.teamsklent_electricvehicles_2023.models

import androidx.compose.ui.graphics.vector.ImageVector

data class BarItem(
    val title: String,
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val route: String
)