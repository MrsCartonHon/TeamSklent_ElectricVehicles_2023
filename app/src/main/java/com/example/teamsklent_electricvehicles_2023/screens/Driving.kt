package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.w3c.dom.Text

@Composable
@Preview
fun Driving(){

    val startTime = System.currentTimeMillis().toDouble()

    var elapsedTime = startTime
    val stop = false

    while (stop.not()){
        Column() {
            Row{

            }

            Row() {
                Text(text = "${(equip1.remainingCapacity/equip1.totalCapacity)/100}%") //percentage
                Text(text = "${getElapsedTime(startTime)}")
            }
            Row() {

            }
        }
    }

}
fun getElapsedTime(startTime: Double): String {
    var hours: Int
    var min: Int
    var elapsedTime = System.currentTimeMillis().toDouble() - startTime
    elapsedTime = elapsedTime/1000 //Convert to seconds
    elapsedTime = elapsedTime/60 // convert To minutes
    min = (elapsedTime % 60).toInt() // remaining minutes
    hours = ((elapsedTime - min)/60).toInt()
    return "${hours}:${min}"
}