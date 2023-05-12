package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.models.Job

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
//    Column {
//        for (itJob in jobs) ListItem(
//            leadingContent = {
//                Icon(
//                    imageVector = Icons.Default.Face,
//                    contentDescription = itJob.jobName,
//                    tint = JDBlack
//                )
//            },
//            headlineContent = {
//                Text(itJob.jobName)
//            },
//            supportingContent = {
//                Text("${(itJob.employees).size}")
//            },
//            trailingContent = {
//                val checked = itJob.completed
//                Checkbox(
//                    checked = checked,
//                    enabled = true,
//                    onCheckedChange = {
//                        itJob.completed = itJob.completed.not()
//                    }
//                )
//            }
//        )
//    }
}