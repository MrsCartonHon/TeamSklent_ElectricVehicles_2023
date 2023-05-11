package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class USER_MANAGMENT() {

    private lateinit var database: DatabaseReference

    init {
        database = Firebase.database.getReferenceFromUrl("https://jdconnect-45f8d-default-rtdb.firebaseio.com")
    }
    val mapper = jacksonObjectMapper()

    fun writeUser(user: User){
        database.child("users").child(user.userName).setValue(mapper.writeValueAsString(user))
            .addOnSuccessListener {
                // Write was successful!
                return@addOnSuccessListener
            }
            .addOnFailureListener {
                // Write failed
                return@addOnFailureListener
            }
    }

    fun getUser(user: User): User? {
        val json = database.child("users").child(user.userName).get().toString()
        val returnUser: User = mapper.readValue(json)
        return returnUser
    }
}