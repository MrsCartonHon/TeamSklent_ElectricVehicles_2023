package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.Job
import com.example.teamsklent_electricvehicles_2023.models.Location
import com.example.teamsklent_electricvehicles_2023.models.User
import com.google.firebase.database.DatabaseReference
import com.google.gson.Gson

class FLEET_MANAGMENT() {
    //DB should be https://console.firebase.google.com/u/0/project/jdconnect-45f8d/database/jdconnect-45f8d-default-rtdb/data/~2F
    private lateinit var database: DatabaseReference


    fun CreateNewFleet(newFleet: Fleet){
        val FLEETNAME = newFleet.owner.userName
        // Add owner of Fleet to Owner Section
        database.child("Owner").child(FLEETNAME).setValue(newFleet.owner)
        // Add managers of Fleet to Manager Section
        database.child("Managers").child(FLEETNAME).setValue(newFleet.managers)
        // Add members of Fleet to Member Section
        database.child("Members").child(FLEETNAME).setValue(newFleet.members)
        // Add jobs of Fleet to Jobs Section
        database.child("Jobs").child(FLEETNAME).setValue(newFleet.jobs)
        // Add equipment of Fleet to Equipment Section
        database.child("Equipment").child(FLEETNAME).setValue(newFleet.fleetEquipment)
        // Add locations of Fleet to Location Section
        database.child("Locations").child(FLEETNAME).setValue(newFleet.locations)
    }

    fun GetFleet(fleetName: String): Fleet? {
        var owner: User? = null
        var managers: ArrayList<User>
        var members: ArrayList<User>
        var jobs: ArrayList<Job>
        var fleetEquipment: ArrayList<Equipment>
        var locations: ArrayList<Location>

        database.child("Owner").child(fleetName).get().addOnSuccessListener {
            owner = Gson().fromJson<User>(it.value.toString(),User::class.java)

        }.addOnFailureListener{
           throw(error("couldnt get data"))
        }


        var deserializedFleet = owner?.let { Fleet(fleetName, it) }
        return deserializedFleet
    }

    fun jsonToUser(json: String){

    }

}