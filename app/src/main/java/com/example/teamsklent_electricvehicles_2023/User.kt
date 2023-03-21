package com.example.teamsklent_electricvehicles_2023

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class User (val username: String, password: CharArray ){



    val createdOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

    //var memberOf = MutableList<Group>()



}