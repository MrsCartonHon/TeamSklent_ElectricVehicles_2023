package com.example.teamsklent_electricvehicles_2023.models

import com.example.teamsklent_electricvehicles_2023.database.DATABASE_MANAGMENT
import com.google.firebase.database.Exclude


data class User(
    var uid: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var ownedEquip: ArrayList<DATABASE_MANAGMENT.Equipment>,
    var ownedFleets: ArrayList<DATABASE_MANAGMENT.Fleet>,
    var memberFleets: ArrayList<DATABASE_MANAGMENT.Fleet>
) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "firstName" to firstName,
            "lastName" to lastName,
            "email" to email,
            "ownedEquip" to ownedEquip,
            "ownedFleets" to ownedFleets,
            "memberFleets" to memberFleets
        )
    }
    @Override
    fun equals(comparedUser: User) :Boolean{
        return (this.uid == comparedUser.uid)
    }
}
