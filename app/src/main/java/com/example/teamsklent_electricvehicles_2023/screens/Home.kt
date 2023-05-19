package com.example.teamsklent_electricvehicles_2023.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.teamsklent_electricvehicles_2023.models.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EquipmentCard(setSheetOpen: (Boolean) -> Unit) {
    ElevatedCard(onClick = { setSheetOpen(true) }) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                AsyncImage(
                    model = "https://crdms.images.consumerreports.org/prod/products/cr/models/256911-lawntractors-johndeere-d125.png",
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        AsyncImage(
                            model = "https://st3.depositphotos.com/1011434/13157/i/600/depositphotos_131572502-stock-photo-happy-woman-smiling.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp, 25.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )

                        Text(
                            text = "John Doe",
                            fontWeight = FontWeight.ExtraBold

                        )
                    }

                    Text(
                        text = "E-XC500",
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    )

                    //Spacer(modifier = Modifier.fillMaxHeight())

                    Row {
                        Icon(Icons.Filled.PinDrop, contentDescription = "", tint = Color.Gray)

                        Text(
                            text = "Bettendorf High School"
                        )
                    }
                }
            }

            Row {
                Text(
                    text = "34%",
                    color = Color.Red
                )

                Icon(Icons.Filled.Battery2Bar, contentDescription = "", tint = Color.Red)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetJob() {
    ElevatedCard(onClick = { /*TODO*/ }) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Jonathan House",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(Icons.Filled.MyLocation, contentDescription = null)

                    Text(
                        text = "2911, Timberline Drive, Waukee, IA",
                        color = Color.Gray
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(Icons.Filled.CalendarMonth, contentDescription = null)

                    Text(
                        text = "10:00 AM, June 1st",
                        color = Color.Gray
                    )
                }
            }

            Icon(Icons.Filled.ChevronRight, contentDescription = null)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EquipmentInfoSheet(sheetOpen: Boolean, setSheetOpen: (Boolean) -> Unit) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded  = true)
    val bhs = LatLng(41.557579, -90.495911)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(bhs, 15f)
    }

    if (sheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { setSheetOpen(false) },
            sheetState = bottomSheetState
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row {
                    AsyncImage(
                        model = "https://crdms.images.consumerreports.org/prod/products/cr/models/256911-lawntractors-johndeere-d125.png",
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp, 150.dp)
                    )

                    Column {
                        Text(
                            text = "E-XC500",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = "https://st3.depositphotos.com/1011434/13157/i/600/depositphotos_131572502-stock-photo-happy-woman-smiling.jpg",
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(35.dp, 35.dp)
                                        .clip(RoundedCornerShape(50.dp))
                                )

                                Text(
                                    text = "John Doe",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 17.sp
                                )
                            }

                            Row {
                                Text(
                                    text = "34%",
                                    color = Color.Red
                                )

                                Icon(Icons.Filled.Battery2Bar, contentDescription = "", tint = Color.Red)
                            }
                        }
                    }
                }

                GoogleMap(
                    modifier = Modifier
                        .height(175.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp)),
                    cameraPositionState = cameraPositionState,
                    uiSettings = MapUiSettings(
                        zoomControlsEnabled = false,
                        rotationGesturesEnabled = false,
                        compassEnabled = false,
                        tiltGesturesEnabled = false,
                        mapToolbarEnabled = false
                    ),
                    properties = MapProperties(mapType = MapType.SATELLITE)
                ) {
                    Marker(
                        state = MarkerState(position = bhs),
                        title = "E-XC500",
                        snippet = "3333 18th St, Bettendorf, IA 52722"
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Jobs",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        SheetJob()
                        SheetJob()
                        SheetJob()
                        SheetJob()
                        SheetJob()
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun Home() {
    val (sheetOpen, setSheetOpen) = remember { mutableStateOf(false) }
    val (actionToggled, setActionToggled) = remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomAppBar { /* Bottom app bar content */ }
        },
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (actionToggled) {
                    ExtendedFloatingActionButton(
                        text = { Text("Create Job") },
                        icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                        onClick = {
                            //navController.navigate("NewJob")
                        }
                    )

                    ExtendedFloatingActionButton(
                        text = { Text("Add Equipment") },
                        icon = { Icon(Icons.Filled.Bluetooth, contentDescription = "") },
                        onClick = {

                        }
                    )
                }

                FloatingActionButton(
                    onClick = { setActionToggled(!actionToggled) }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "")
                }
            }
        }
    ) {
        EquipmentInfoSheet(sheetOpen, setSheetOpen)


        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(content = {
                Text(text = "My Equipment", Modifier.absolutePadding(10.dp, 0.dp, 30.dp, 0.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    content = { Icons.Default.AddBox}
                )
            })

            EquipmentCard(setSheetOpen)
            EquipmentCard(setSheetOpen)
            EquipmentCard(setSheetOpen)
            EquipmentCard(setSheetOpen)
            EquipmentCard(setSheetOpen)
            EquipmentCard(setSheetOpen)
        }
    }
}
