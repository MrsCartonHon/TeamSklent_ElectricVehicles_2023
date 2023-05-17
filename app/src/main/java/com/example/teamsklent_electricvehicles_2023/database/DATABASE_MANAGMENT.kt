package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.EquipmentModel
import com.example.teamsklent_electricvehicles_2023.models.Location
import com.example.teamsklent_electricvehicles_2023.models.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Exclude
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class DATABASE_MANAGMENT {
    private var database: DatabaseReference = Firebase.database.getReferenceFromUrl("https://jdconnect-45f8d-default-rtdb.firebaseio.com")

    /* I don't think Jobs need a UUID if they have a unique name only visible to a particular fleet */
    data class Job(
//        var id: UUID = UUID.randomUUID(),
        var name: String = "A cool job name",
        var date: Date,
        var location: Location,
        var notes: String,
        var completed: Boolean,
        var createdOn: Date
    ) {
        @Exclude
        fun toMap(): Map<String, Any?> {
            return mapOf(
//                "id" to id,
                "name" to name,
                "date" to date,
                "location" to location,
                "completed" to completed,
                "createdOn" to createdOn
            )
        }
    }

    data class Equipment(
        var id: UUID? = UUID.randomUUID(),
        var nickname: String,
        var model: EquipmentModel? = EquipmentModel.EXC350,
        var operators: ArrayList<User>
    ) {
        @Exclude
        fun toMap(): Map<String, Any?> {
            return mapOf(
                "id" to id,
                "nickname" to nickname,
                "model" to model,
                "operators" to operators
            )
        }
    }


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
                "username" to uid,
                "firstName" to firstName,
                "lastName" to lastName,
                "email" to email,
                "ownedEquip" to ownedEquip,
                "ownedFleets" to ownedFleets,
                "memberFleets" to memberFleets
            )
        }
    }

    data class Fleet(
        var id: UUID = UUID.randomUUID(),
        var owner: User,
        var name: String,
        var managers: ArrayList<User>,
        var employees: ArrayList<User>,
        var equipment: ArrayList<Equipment>,
        var jobs: ArrayList<Job>,
        var locations: ArrayList<Location>
    ) {
        @Exclude
        fun toMap(): Map<String, Any?> {
            return mapOf(
                "id" to id,
                "name" to name,
                "owner" to owner,
                "managers" to managers,
                "employees" to employees,
                "equipment" to equipment,
                "jobs" to jobs,
                "locations" to locations
            )
        }
    }

    data class Location(
        var name: String,
        var lat: Double,
        var lon: Double
    ){
        @Exclude
        fun toMap(): Map<String, Any?> {
            return mapOf(
                "name" to name,
                "latitude" to lat,
                "longitude" to lon
            )
        }
    }
}