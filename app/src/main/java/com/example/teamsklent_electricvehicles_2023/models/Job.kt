package com.example.teamsklent_electricvehicles_2023.models

import com.fasterxml.jackson.annotation.JsonBackReference

class Job (
    @JsonBackReference
    var fleet: Fleet, // identifier of fleet assigned to
    var jobName: String, // display name of the job
    var location: Location, // location of job
    var employees: ArrayList<User> = ArrayList(), // list of employees tasked with the job
    var completed: Boolean = false
){
    fun changeCompleted(){
        completed = !completed
    }

}