package com.example.teamsklent_electricvehicles_2023.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamsklent_electricvehicles_2023.models.EquipmentModel
import com.example.teamsklent_electricvehicles_2023.models.ExampleEquipment
import com.example.teamsklent_electricvehicles_2023.models.ExampleLocation

@Composable
@Preview
fun Driving(){




    val bhs = ExampleLocation("Bettendorf High school", 41.5527552, -90.4718601)
    val currentEquip = ExampleEquipment(
        "equip1", EquipmentModel.EXC350, bhs,
        System.currentTimeMillis().toDouble(), 100.0, 75.0
    )

    val startTime = System.currentTimeMillis().toDouble()

    var upTime = remember { mutableStateOf(ElapsedTime(startTime = startTime)) }

    val startCapacity: Double = currentEquip.remainingCapacity

    var stop = false
    var remainingCard:Composable
    var elapsedCard: Composable


    Column() {
        Row{

        }

        Row{
            infoCard(title = "Remaining", content = "${(currentEquip.remainingCapacity/currentEquip.totalCapacity)/100}%")
            infoCard(title = "Elapsed", content = "${upTime.value.getHours()}:${upTime.value.getMinutes()}")
        }
        Row{
            TextButton(
                onClick = { stop = false },
                content = { Text(text = "EXIT")}
            ) 
        }
    }
}
data class ElapsedTime(
    val startTime: Double
    ){
    val elapsedTime: Double = ((System.currentTimeMillis().toDouble() - startTime)/60000)
    val hour: Int
    val min: Int = (elapsedTime % 60).toInt()


    init {
        hour = ((elapsedTime - min)/60).toInt()
    }


    fun getMinutes(): Int {
        return min
    }
    fun getHours(): Int {
        return hour
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun infoCard(title: String, content: String){
    Card(
        onClick = { /* Do something */ },
        modifier = Modifier.size(width = 180.dp, height = 100.dp)
    ) {
        Box(Modifier
            .fillMaxSize()
            .align(Alignment.CenterHorizontally)) {
            Column {
                Row{
                    Text(text = title)
                }
                Row{
                    Text(text = content)
                }
            }
        }
    }
}

@Composable
fun cardDisplayUnit(
    title: String,
    content: String
){

}