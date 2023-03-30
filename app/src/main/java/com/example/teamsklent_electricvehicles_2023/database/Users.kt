package com.example.teamsklent_electricvehicles_2023.database

import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

abstract class Users(val db : FirebaseFirestore) {

     class User(
        internal var name: String,
        internal var id: UUID = UUID.randomUUID(), // identifier of user
        internal var password: String = "", // Password of the user
        internal var fleets: ArrayList<Fleet>
    ){
         @Override
         fun equals(comparedUser: User) :Boolean{
             return (this.id == comparedUser.id && this.name == comparedUser.name)
         }
    }


}