package com.example.teamsklent_electricvehicles_2023

sealed class Tractor(var name: String, var icon: Int, var AHCapacity: Double){
    object x250 : Tractor("X-250EV", 2, 250.0)
}
