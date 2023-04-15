package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.teamsklent_electricvehicles_2023.database.Fleet
import com.example.teamsklent_electricvehicles_2023.models.User

@Composable
fun FleetManagment(navController: NavHostController){
    val thisFleet: Fleet
    val fleetEmployees: ArrayList<User>


//    var items by remember {
//        mutableStateOf(
//            fleetEmployees.map {
//                com.example.teamsklent_electricvehicles_2023.models.ListItem(
//                    title = it.username,
//                    isSelected = false
//                )
//            }
//        )
//    }

    val openRemoveUser = remember{ mutableStateOf(false) } // Is the dialog open

//    if(openRemoveUser.value){
//       AlertDialog(
//           containerColor = MaterialTheme.colorScheme.tertiaryContainer, //
//           title = { Text(text = "Select Employees") }, //
//           onDismissRequest = { /*TODO*/ }, //
//           text = {
//               LazyColumn(
//                   modifier = Modifier
//                       .fillMaxSize()
//               ) {
//                   items(items.size) { i ->
//                       Row(
//                           modifier = Modifier
//                               .fillMaxWidth()
//                               .clickable {
//                                   items = items.mapIndexed { j, item ->
//                                       if (i == j) {
//                                           item.copy(isSelected = !item.isSelected)
//                                       } else item
//                                   }
//                               }
//                               .padding(20.dp),
//                           horizontalArrangement = Arrangement.SpaceBetween,
//                           verticalAlignment = Alignment.CenterVertically
//                       ) {
//                           Text(text = items[i].title) // the title of the
//                           if (items[i].isSelected) {
//                               Icon( // the selection icon for selected elements
//                                   imageVector = Icons.Default.Check,
//                                   contentDescription = "Selected",
//                                   tint = Color.Green,
//                                   modifier = Modifier.size(20.dp)
//                               )
//                           }
//                       }
//                   }
//               }
//           },
//           confirmButton = {
//               TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Done") }
//           },
//           dismissButton = {
//               TextButton(onClick = { openRemoveUser.value = false }) { Text(text = "Cancel") }
//           }
//       )
//    }
}