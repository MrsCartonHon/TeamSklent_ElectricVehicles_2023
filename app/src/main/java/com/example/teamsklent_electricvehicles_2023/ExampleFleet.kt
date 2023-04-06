package com.example.teamsklent_electricvehicles_2023

import com.example.teamsklent_electricvehicles_2023.database.Fleet
import com.example.teamsklent_electricvehicles_2023.database.Users
import java.util.*
import kotlin.collections.ArrayList

object ExampleFleet {

    val ownerUser = Users.User("Dominic", UUID.randomUUID().toString(),"1234", ArrayList())
    val member =  Users.User("Jackson", UUID.randomUUID().toString(),"1234", ArrayList())
    private val manager = Users.User("Nirmal", UUID.randomUUID().toString(),"1234", ArrayList())


    val Fleet1 = Fleet.FleetData(UUID.randomUUID(),"ThisDamnCandy", ownerUser, ArrayList<User>(manager), ArrayList<User>(member) )

    val fleets = listOf(
        Fleet.Location("school", 3.14,9.82)

    )
}