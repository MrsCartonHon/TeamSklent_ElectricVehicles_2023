package com.example.teamsklent_electricvehicles_2023.models

class Job (
    var jobName: String, // display name of the job
    var fleet: String, // identifier of fleet assigned to
    var location: Location, // location of job
    var employees: ArrayList<User> = ArrayList(), // list of employees tasked with the job
    var completed: Boolean = false
    ){
    fun changeCompleted(){
        completed = !completed
    }

}