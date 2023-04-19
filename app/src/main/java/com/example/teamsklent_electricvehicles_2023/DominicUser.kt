package com.example.teamsklent_electricvehicles_2023

import com.example.teamsklent_electricvehicles_2023.models.User

object DominicUser {
    val owner = User("dominic05", "Dominic", "Halbur", "dominic.halbur@outlook.com")

    val managers = listOf(
        User(
            "nirmal05",
            "Nirmal",
            "Alla",
            "nirmal.alla@gmail.com"
        ),
        User("jackson05", "Jackson", "GermanWord", "jackson.germanword@outlook.com")
    )
    val employees = listOf(
        User(
            "nirmal05",
            "Nirmal",
            "Alla",
            "nirmal.alla@gmail.com"
        ),
        User(
            "jackson05",
            "Jackson",
            "GermanWord",
            "jackson.germanword@outlook.com"
        )
    )
}