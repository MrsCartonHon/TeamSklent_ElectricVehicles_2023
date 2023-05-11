package com.example.teamsklent_electricvehicles_2023.models

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.json.JSONObject
import java.net.URL
import java.nio.charset.Charset

class Weather(
    val location: Location
) {
    var lon: Double = 0.0
    var lat: Double = 0.0

    init {
        lon = location.lon
        lat = location.lat
    }

    fun getWeather(): String {
        val mapper = ObjectMapper().registerModule(KotlinModule())

        val url1 = URL("https://api.weather.gov/points/${lat},${lon}").readText(charset = Charset.defaultCharset())
        val json1 = JSONObject(url1)

        return json1.getJSONArray("properties").getString(6)

        //THE
        // https://api.weather.gov/points/{latitude},{longitude}
        // properties.grid ID == office


        //THE FORECAST
        // https://api.weather.gov/gridpoints/{office}/{grid X},{grid Y}/forecast
    }


}