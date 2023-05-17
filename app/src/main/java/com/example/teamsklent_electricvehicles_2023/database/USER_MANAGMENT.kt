package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.User
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class USER_MANAGMENT {

    private val database = Firebase.firestore.collection("users")

    fun getUser(uid:String): User? {
        var user: User? = null
        database.document(uid).get()
            .addOnSuccessListener { documentSnapshot ->
                user = documentSnapshot.toObject<User>()
            }
        return user
    }

    fun writeUser(user: User){
        if(exists(user.uid)){
            database.document(user.uid).set(user.toMap(), SetOptions.merge()) // Merges changed data
        }else{
            database.document(user.uid).set(user.toMap()) // creates new document
        }
    }

    fun exists(username:String): Boolean {
        var returnData = false
        database.document(username).get()
            .addOnSuccessListener {
                returnData = true
            }
        return returnData
    }
}