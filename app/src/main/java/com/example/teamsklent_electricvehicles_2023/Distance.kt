package com.example.teamsklent_electricvehicles_2023

import androidx.compose.runtime.Composable
import com.example.teamsklent_electricvehicles_2023.Vendors

@Composable
fun calculation(lat1: Double, lat2: Double, long1: Double, long2: Double): Double {
    var dLat = (lat2 - lat1) * 69.0
    var dLong = (long2 - long1) * 54.6
    var distance = Math.pow(Math.pow(dLat, 2.0) + Math.pow(dLong, 2.0), 0.5)
    return distance
}

@Composable
fun optimization(lat: Double, long: Double): String{
    var locationCity = ""
    var minimum = calculation(lat, long, Vendors.Locations[0].latitude, Vendors.Locations[0].longitude)
    Vendors.Locations.forEach{
        var distance = calculation(it.latitude, it.longitude, lat, long)
        if (distance < minimum){
            locationCity = it.city
        }
    }

    return locationCity
}