package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.Fleet
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


//DB should be https://console.firebase.google.com/u/0/project/jdconnect-45f8d/database/jdconnect-45f8d-default-rtdb/data/~2F
class FLEET_MANAGMENT {
    private var database = Firebase.firestore.collection("fleets")

    fun getFleet(name:String): Fleet? {
        var fleet: Fleet? = null
        database.document(name).get()
            .addOnSuccessListener { documentSnapshot ->
                fleet = documentSnapshot.toObject<Fleet>()
            }
        return fleet
    }
    fun isNameTaken(name:String): Boolean {
        var returnData = false
        database.document(name).get()
            .addOnSuccessListener {
                returnData = true
            }
        return returnData
    }
}