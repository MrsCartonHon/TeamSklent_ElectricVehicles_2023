package com.example.teamsklent_electricvehicles_2023.models

import com.example.teamsklent_electricvehicles_2023.database.Fleet
import com.google.gson.Gson

class User{
    var userName: String
    var fName: String
    var lName: String
    var email: String
    var fleets: ArrayList<Fleet>

    constructor(userName: String, fName: String, lName:String, email:String){
        this.userName = userName
        this.fName = fName
        this.lName = lName
        this.email = email
        fleets = ArrayList()
    }
    constructor(userName: String, fName: String, lName:String, email:String, fleets: ArrayList<Fleet>){
        this.userName = userName
        this.fName = fName
        this.lName = lName
        this.email = email
        this.fleets = fleets
    }
    @Override
    fun equals(comparedUser: User) :Boolean{
        return (this.userName == comparedUser.userName)
    }
    @Override
    override fun toString(): String{
        return "${userName},${fName},${lName}"
    }

    fun toJSON():String{
        return Gson().toJson(this)
    }
}
