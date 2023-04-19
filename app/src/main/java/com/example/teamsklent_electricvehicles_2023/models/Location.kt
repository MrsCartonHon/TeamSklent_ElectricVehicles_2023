package com.example.teamsklent_electricvehicles_2023.models

import com.fasterxml.jackson.annotation.JsonBackReference

class Location(
    @JsonBackReference
    var fleet: Fleet, // identifier of fleet assigned to
    var name: String,
    var lat: Double,
    var lon: Double
){

}
