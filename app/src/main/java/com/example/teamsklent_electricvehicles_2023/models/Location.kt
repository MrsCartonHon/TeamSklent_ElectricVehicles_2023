package com.example.teamsklent_electricvehicles_2023.models

import com.google.gson.Gson

class Location(
    internal var name: String,
    internal var lat: Double,
    internal var lon: Double
){
    fun toJSON():String{
        return Gson().toJson(this)
    }
}
