package com.example.teamsklent_electricvehicles_2023

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamsklent_electricvehicles_2023.screens.Dropdown
import com.example.teamsklent_electricvehicles_2023.ui.theme.TeamSklent_ElectricVehicles_2023Theme
import com.example.teamsklent_electricvehicles_2023.screens.Login
import com.example.teamsklent_electricvehicles_2023.screens.requestPermissions
import com.example.teamsklent_electricvehicles_2023.screens.Pair
import com.example.teamsklent_electricvehicles_2023.screens.CalendarDisplay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            TeamSklent_ElectricVehicles_2023Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.deere_logo),
                            contentDescription = stringResource(id = R.string.deere_logo),
                            modifier = Modifier.padding(bottom = 0.dp)
                        )
                        CalendarDisplay()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TeamSklent_ElectricVehicles_2023Theme {
        Greeting("Android")
    }
}

