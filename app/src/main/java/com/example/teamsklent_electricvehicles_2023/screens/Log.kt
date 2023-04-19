package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.models.Job
import com.example.teamsklent_electricvehicles_2023.ui.theme.JDBlack

@Composable
fun Logs(navController: NavHostController) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        //showJobs(jobs = ExampleJobs.jobs)
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showJobs(jobs: List<Job>){
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
                Text("${(job.employees).size}")
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
