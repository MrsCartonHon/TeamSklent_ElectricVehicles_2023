package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.database.Fleet.Location
import com.example.teamsklent_electricvehicles_2023.database.Users.User
import com.google.firebase.firestore.FirebaseFirestore
import java.sql.Time
import java.util.*

abstract class Equipment(val db : FirebaseFirestore) {

    enum class EquipmentModel {
        EXC500,
        EXC350,
        EXC450
    }


    data class EquipmentData(
        internal var name: String = "", // TODO maybe keep??
        internal var id: UUID = UUID.randomUUID(), // identifier of equipment
        internal var model: EquipmentModel, // model of equipment
        internal var fleet: UUID = UUID.randomUUID(), // identifier of fleet
        internal var employees: ArrayList<User>, // assigned employees to this equipment
        internal var location: Location = Location(name = "", lat = 0.0, lon = 0.0),
        internal var lastChargedAt: Time,
        internal var totalCapacity: Double,
        internal var remainingCapacity: Double,
    ){
        fun getLocation(){

        }

    }


}