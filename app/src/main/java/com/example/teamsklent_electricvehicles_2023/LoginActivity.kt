package com.example.teamsklent_electricvehicles_2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.teamsklent_electricvehicles_2023.ui.theme.TeamSklent_ElectricVehicles_2023Theme
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : ComponentActivity() {

    // [START declare_auth]
    private var auth: FirebaseAuth? = null
    // [END declare_auth]

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        // val currentUser = auth.currentUser
//        updateUI(currentUser)
        setContent {
            TeamSklent_ElectricVehicles_2023Theme {
                MainScreen(auth)
            }
        }
    }
}