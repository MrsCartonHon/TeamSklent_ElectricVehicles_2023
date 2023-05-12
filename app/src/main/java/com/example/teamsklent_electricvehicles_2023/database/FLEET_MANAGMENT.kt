package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.Fleet
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


//DB should be https://console.firebase.google.com/u/0/project/jdconnect-45f8d/database/jdconnect-45f8d-default-rtdb/data/~2F
class FLEET_MANAGMENT() {
    private lateinit var database: DatabaseReference
    init {
        database = Firebase.database.getReferenceFromUrl("https://jdconnect-45f8d-default-rtdb.firebaseio.com")
    }

    val mapper = jacksonObjectMapper()

    fun writeFleet(fleet: Fleet){
        database.child("fleets").child(fleet.name).setValue(mapper.writeValueAsString(fleet))
            .addOnSuccessListener {
                // Write was successful!
                return@addOnSuccessListener
            }
            .addOnFailureListener {
                // Write failed
                return@addOnFailureListener
            }
    }
}