package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.models.Job
import com.example.teamsklent_electricvehicles_2023.models.Location
import com.example.teamsklent_electricvehicles_2023.models.User

class Fleet{
    var name: String // name of the company
    var owner: User // identifier of owner
    var managers: ArrayList<User> // managers of the fleet
    var members: ArrayList<User>  // employees within the fleet aside from the owner and managers
    var jobs: ArrayList<Job>  // The jobs of the fleet
    var fleetEquipment: ArrayList<Equipment>  // The Equipment owned by the fleet
    var locations: ArrayList<Location> // The Saved locations of the Fleet

    constructor(name: String, owner: User){
        this.name = name
        this.owner = owner
        managers = ArrayList() // initializes managers
        members = ArrayList() // employees within the fleet aside from the owner and managers
        jobs = ArrayList() // initializes jobs
        fleetEquipment = ArrayList() // initializes fleetEquipment
        locations = ArrayList() // initializes locations
    }

    constructor(
        name: String,
        owner: User,
        managers: ArrayList<User>,
        members: ArrayList<User>,
        jobs: ArrayList<Job>,
        fleetEquipment: ArrayList<Equipment>,
        locations: ArrayList<Location>
    ){
        this.name = name
        this.owner = owner
        this.managers = managers
        this.members = members
        this.jobs = jobs
        this.fleetEquipment = fleetEquipment
        this.locations = locations
    }

    /**
     * @param [currentUser] the user that is currently logged in
     * @return whether or not the current user is the fleetOwner
     */
    fun isOwner(currentUser: User) : Boolean {
        return this.owner.equals(currentUser)
    }
    /**
     * @return An [ArrayList] of [User] that are non manager members
     */
    fun members(): ArrayList<User> {
        return members
    }
    /**
     * @return [ArrayList] of [User] of manager members
     */
    fun managers(): ArrayList<User> {
        return this.managers
    }
    /**
     * If the [currentUser] is a manager or the owner the [newUser] becomes a member of the fleet
     * @param currentUser [User] that is logged in
     * @param newUser [User] to be added
     */
    fun addMember(currentUser: User, newUser:User){
        if(isOwner(currentUser) || isManager(currentUser)) {
            members.add(newUser)
        }
    }
    /**
     * Assesses if a [User] is a manager of the Fleet
     * @param someUser [User] to be assessed
     */
    fun isManager(someUser: User): Boolean {
        if(managers().isEmpty().not()){
            this.managers.forEach(){
                if(someUser.equals(it)){
                    return true
                }
            }
        }
        return false
    }
    /**
     * Assesses if a [User] is a member of the Fleet
     */
    fun isMember(someUser: User): Boolean {
        if(members().isEmpty().not()){
            members.forEach(){
                if(someUser.equals(it)){
                    return true
                }
            }
        }
        return false
    }
    /**
     * Make a [User] a manager in the fleet
     */
    fun makeManager(toBeManager: User){
        if(this.isManager(toBeManager)){
            // Already a manager
        }else if(this.isMember(toBeManager)){
            this.managers.remove(toBeManager) // removes User from member list
        }else{
            managers.add(toBeManager) // adds user to manager list
        }
    }
    fun identifier(): String{
        return name
    }

}