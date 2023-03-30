package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamsklent_electricvehicles_2023.ExampleUsers
import com.example.teamsklent_electricvehicles_2023.ListItem
import com.example.teamsklent_electricvehicles_2023.database.Fleet
import com.example.teamsklent_electricvehicles_2023.database.Users

@Preview
@Composable
fun FleetMangment(){
    val thisFleet: Fleet.FleetData
    val fleetEmployees: ArrayList<Users.User>


    var items by remember {
        mutableStateOf(
            fleetEmployees.map {
                ListItem(
                    title = it.username,
                    isSelected = false
                )
            }
        )
    }

    var openRemoveUser = remember{ mutableStateOf(false) } // Is the dialog open

   if(openRemoveUser){
       AlertDialog(
           containerColor = MaterialTheme.colorScheme.tertiaryContainer,
           title = { Text(text = "Select Employees") },
           onDismissRequest = { /*TODO*/ },
           text = {
               LazyColumn(
                   modifier = Modifier
                       .fillMaxSize()
               ) {
                   items(items.size) { i ->
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .clickable {
                                   items = items.mapIndexed { j, item ->
                                       if (i == j) {
                                           item.copy(isSelected = !item.isSelected)
                                       } else item
                                   }
                               }
                               .padding(20.dp),
                           horizontalArrangement = Arrangement.SpaceBetween,
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           Text(text = items[i].title)
                           if (items[i].isSelected) {
                               Icon(
                                   imageVector = Icons.Default.Check,
                                   contentDescription = "Selected",
                                   tint = Color.Green,
                                   modifier = Modifier.size(20.dp)
                               )
                           }
                       }
                   }
               }
           },
           confirmButton = {
               TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Done") }
           },
           dismissButton = {
               TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Cancel") }
           }
       )
   }
}
fun getFleet(name:String) :Fleet{
    return Fleet
}