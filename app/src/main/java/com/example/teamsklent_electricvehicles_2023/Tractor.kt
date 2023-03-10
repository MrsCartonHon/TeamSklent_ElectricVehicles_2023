package com.example.teamsklent_electricvehicles_2023

sealed class Tractor(var name: String, var icon: Int, var AHCapacity: Double){
    object X250 : Tractor("X-250EV", 2, 250.0)
    object X300 : Tractor("X-300EV", 2, 300.0)
    object X350 : Tractor("X-350", 2, 350.0)
}
