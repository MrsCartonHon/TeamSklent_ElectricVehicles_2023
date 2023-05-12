package com.example.teamsklent_electricvehicles_2023.models

class ExampleEquipment(
    var name: String,
    var model: EquipmentModel, // model of equipment
    var location: ExampleLocation, // location of the equipment
    var lastChargedAt: Double,
    var totalCapacity: Double,
    var remainingCapacity: Double
) {

}