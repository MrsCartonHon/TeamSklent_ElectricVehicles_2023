package com.example.teamsklent_electricvehicles_2023.database

import com.google.firebase.firestore.FirebaseFirestore
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
        internal var model: EquipmentModel = EquipmentModel.EXC350, // model of equipment
        internal var fleet: UUID = UUID.randomUUID(), // identifier of fleet
        internal var employees: ArrayList<UUID> = ArrayList() // assigned employees to this equipment
    )


}