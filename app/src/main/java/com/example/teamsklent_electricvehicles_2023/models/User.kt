package com.example.teamsklent_electricvehicles_2023.models

class User{
    var userName: String
    var fName: String
    var lName: String
    var email: String
    var fleets: ArrayList<String>

    constructor(userName: String, fName: String, lName:String, email:String){
        this.userName = userName
        this.fName = fName
        this.lName = lName
        this.email = email
        fleets = ArrayList()
    }
    constructor(userName: String, fName: String, lName:String, email:String, fleets: ArrayList<String>){
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
    override fun toString(): String {
        return userName
    }
}
