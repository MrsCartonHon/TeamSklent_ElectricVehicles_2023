@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teamsklent_electricvehicles_2023.TractorTypes
import com.example.teamsklent_electricvehicles_2023.ui.theme.JDGreen1
import com.example.teamsklent_electricvehicles_2023.ui.theme.JDYellow

@Preview
@Composable
fun Home() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            TractorTypes.Tractors.forEach{navItem ->
                ListItem(
                    headlineText = {navItem.name},
                    supportingText = {navItem.capacity},
                    leadingContent = {
                        Icon(
                            navItem.icon,
                            contentDescription = navItem.name,
                        )
                    }
                )
                Divider()
            }
        }
    }
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = JDGreen1,
        contentColor = JDYellow,
        content = {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "drive", tint = JDYellow)
        }
    )
}