package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.Location
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

abstract class Fleet(val db : FirebaseFirestore) {

     class FleetData(
         internal var id: UUID = UUID.randomUUID(), // identifier of fleet
         internal var name: String = "", // name of the company
         internal var owner: UUID = UUID.randomUUID(), // identifier of owner
         private var members: ArrayList<UUID> = ArrayList() // employees within the fleet aside from the owner
    ){
        fun members(): ArrayList<UUID> {
            return this.members
        }
    }


    data class Job(
        internal var id: UUID = UUID.randomUUID(), // identifier of job
        internal var fleet: UUID = UUID.randomUUID(), // identifier of fleet assigned to
        internal var location: Location = Location(name = "", lon = 0.0, lat = 0.0), // location of job
        internal var employees: ArrayList<UUID> = ArrayList() // list of employees tasked with the job
    )

}