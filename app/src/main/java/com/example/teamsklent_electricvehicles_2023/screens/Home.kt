package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.models.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, ) {
    val nirmal = User("nirmal05", "Nirmal", "Alla", "nirmal.alla@gmail.com")
    val jackson = User("jackson05", "Jackson", "Tagtmeier", "jakson@gmail.com")
    val dominic = User("dominic05", "Dominic", "Halbur", "dominic.halbur@outlook.com")
    val exampleFleet = Fleet("Fake example fleet", dominic)
    val bhs = Location(exampleFleet, "Bettendorf High school", 41.5527552, -90.4718601)
    val jdh = Location(exampleFleet, "JD World Headquarters", 41.476482, -90.42467)
    val equip1 = Equipment(
        exampleFleet, "equip1", EquipmentModel.EXC350, exampleFleet.members, bhs,
        System.currentTimeMillis().toDouble(), 100.0, 0.0
    )
    val equip2 = Equipment(
        exampleFleet, "equip2", EquipmentModel.EXC500, exampleFleet.members, bhs,
        System.currentTimeMillis().toDouble(), 100.0, 0.0
    )
    val job1 = Job(exampleFleet, "BHS Courtyard", bhs, exampleFleet.members, false)
    exampleFleet.addMember(nirmal)
    exampleFleet.addManager(jackson)
    exampleFleet.locations.add(bhs)
    exampleFleet.locations.add(jdh)
    exampleFleet.fleetEquipment.add(equip1)
    exampleFleet.fleetEquipment.add(equip2)
    exampleFleet.jobs.add(job1)

    Column {
        Card(onClick = { /*TODO*/ }) {
            Row(content = {
                Text(text = "My Equipment", Modifier.absolutePadding(10.dp, 0.dp, 30.dp, 0.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    content = {Icons.Default.AddBox}
                )
            })
            exampleFleet.fleetEquipment.forEach{ equip ->
               if(exampleFleet.fleetEquipment.isEmpty().not()){
                   ListItem(
                       headlineContent = {Text("${equip.name}", fontSize = 20.sp)},
                       supportingContent = { Text(text = "${equip.model}", modifier = Modifier.size(10.dp))}

                   )
               }else{
                   Text(text = "Add some equipment")
               }
            }
        }
    }
}

