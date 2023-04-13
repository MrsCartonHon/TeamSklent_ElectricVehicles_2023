package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teamsklent_electricvehicles_2023.ExampleJobs
import com.example.teamsklent_electricvehicles_2023.database.Fleet
import com.example.teamsklent_electricvehicles_2023.ui.theme.JDBlack

@Composable
@Preview
fun Logs() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        showJobs(jobs = ExampleJobs.jobs)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showJobs(jobs: List<Fleet.Job>){
    Column {
        for (job in jobs) ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = job.jobName,
                    tint = JDBlack
                )
            },
            headlineText = {
               Text(job.jobName)
            },
            supportingText = {
                //Text("${numOfEmployees(job.employees)}")
            },
            trailingContent = {
                val checked = job.completed
                Checkbox(
                    checked = checked,
                    enabled = true,
                    onCheckedChange = {
                        job.completed = job.completed.not()
                    }
                )
            }
        )
    }
}
