package com.example.teamsklent_electricvehicles_2023

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Group(val name: String, val creator: User, managerUsers: MutableList<User>, operatorUsers: MutableList<User>) {

    val createdOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    var managers = managerUsers
    var operators = operatorUsers


    fun addManager(newManager: User){
        managers.add(newManager)
    }
    fun removeManager(manager: User){
        managers.remove(manager)
    }

    fun addOperator(newOperator: User){
        operators.add(newOperator)
    }
    fun removeOperator(operator: User){
        operators.remove(operator)
    }

    fun wasCreatedOn(): String{
        return createdOn
    }
}
