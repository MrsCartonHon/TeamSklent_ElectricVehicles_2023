package com.example.teamsklent_electricvehicles_2023.models

class Fleet(
    val name: String? = null,
    val owner: User? = null,
    ) {
    var managers: ArrayList<User> = ArrayList() // managers of the fleet
    var members: ArrayList<User> = ArrayList() // employees within the fleet aside from the owner and managers
}
