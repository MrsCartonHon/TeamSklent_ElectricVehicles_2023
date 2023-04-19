package com.example.teamsklent_electricvehicles_2023.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.sql.Time

class Equipment(

    @JsonBackReference
    var fleet: Fleet,
    var name: String,
    var model: EquipmentModel, // model of equipment
    @JsonManagedReference
    var employees: ArrayList<User>, // assigned employees to this equipment
    var location: Location, // location of the equipment
    var lastChargedAt: Time,
    var totalCapacity: Double,
    var remainingCapacity: Double
){
    fun addEmployee(employee: User) {
        employees.add(employee)
    }
}