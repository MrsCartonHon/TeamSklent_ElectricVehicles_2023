package com.example.teamsklent_electricvehicles_2023.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference


class Fleet{
    var name: String // name of the company
    @JsonBackReference
    var owner: User // identifier of owner
    @JsonManagedReference
    var managers: ArrayList<User> // managers of the fleet
    @JsonManagedReference
    var members: ArrayList<User>  // employees within the fleet aside from the owner and managers
    @JsonManagedReference
    var jobs: ArrayList<Job>  // The jobs of the fleet
    @JsonManagedReference
    var fleetEquipment: ArrayList<Equipment>  // The Equipment owned by the fleet
    @JsonManagedReference
    var locations: ArrayList<Location> // The Saved locations of the Fleet


    /**
     * For creating a completely new Fleet
     * @param name the name of the new Fleet
     * @param owner [User] that will be the owner of the new fleet
     */
    constructor(name: String, owner: User){
        this.name = name
        this.owner = owner
        managers = ArrayList() // initializes managers
        members = ArrayList() // employees within the fleet aside from the owner and managers
        jobs = ArrayList() // initializes jobs
        fleetEquipment = ArrayList() // initializes fleetEquipment
        locations = ArrayList() // initializes locations
    }

    /**
     * A constructor with all values settable, intended to be used with JSON parsing
     */
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
     * Adds a [newMember] to the Fleet members
     * @param newUser [User] to be added
     */
    fun addMember(newMember: User){
        members.add(newMember)
    }
    /**
     * Adds a [user] to the Fleet Ma
     * @param newManager [User] to be added
     */
    fun addManager(newManager: User){
        managers.add(newManager)
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

    fun addJob(job: Job){
        jobs.add(job)
    }
    fun addLocation(location: Location){
        locations.add(location)
    }
}