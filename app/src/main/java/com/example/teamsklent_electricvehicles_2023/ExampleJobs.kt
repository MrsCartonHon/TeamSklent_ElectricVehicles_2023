package com.example.teamsklent_electricvehicles_2023

import com.example.teamsklent_electricvehicles_2023.database.Fleet.Job
import java.util.*


object ExampleJobs {
    val jobs = listOf(
        Job(
            id = UUID.randomUUID(),
            jobName = "Stevenson's House",
            fleet = UUID.randomUUID(),
            location = ExampleLocations.Locations[0],
            employees = ExampleUsers.users,
            completed = false
        ),
        Job(
            id = UUID.randomUUID(),
            jobName = "Johnson's House",
            fleet = UUID.randomUUID(),
            location = ExampleLocations.Locations[1],
            employees = ExampleUsers.users,
            completed = true
        ),
        Job(
            id = UUID.randomUUID(),
            jobName = "School's Field",
            fleet = UUID.randomUUID(),
            location = ExampleLocations.Locations[2],
            employees = ExampleUsers.users,
            completed = false
        )
    )
}