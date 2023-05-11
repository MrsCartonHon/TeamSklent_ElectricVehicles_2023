package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.EquipmentModel
import com.example.teamsklent_electricvehicles_2023.models.Location
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Exclude
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.Date
import java.util.UUID


data class Job(
    var id: UUID = UUID.randomUUID(),
    var name: String = "A cool job name",
    var date: Date,
    var location: Location
) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "name" to name,
            "date" to date,
            "location" to location
        )
    }
}

data class Equipment(
    var id: UUID? = UUID.randomUUID(),
    var model: EquipmentModel? = EquipmentModel.EXC350,
    var operators: List<User>
    ) {


    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "model" to model,
            "operators" to operators
        )
    }
}

data class User(
    var id: UUID? = UUID.randomUUID(),
    var username: String = "",
    var firstName: String = "",
    var lastName: String = ""
    ) {



    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "username" to username,
            "firstName" to firstName,
            "lastName" to lastName
        )
    }
}

data class Fleet(
    var id: UUID = UUID.randomUUID(),
    var owner: User,
    var managers: List<User>,
    var employees: List<User>,
    var equipment: List<Equipment>,
    var jobs: List<Job>
) {


    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "owner" to owner,
            "managers" to managers,
            "employees" to employees,
            "equipment" to equipment,
            "jobs" to jobs
        )
    }
}

class FLEET_MANAGMENT() {
    //DB should be https://console.firebase.google.com/u/0/project/jdconnect-45f8d/database/jdconnect-45f8d-default-rtdb/data/~2F
    private var db: DatabaseReference = Firebase.database.reference

    fun createFleet() {
        var fleetId = UUID.randomUUID() // generate id for fleet

        //db.child("fleets").child(fleetId.toString()).setValue() // insert fleet
    }
}