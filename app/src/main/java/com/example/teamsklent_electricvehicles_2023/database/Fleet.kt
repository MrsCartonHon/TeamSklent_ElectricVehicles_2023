package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.database.Users.User
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

abstract class Fleet(val db : FirebaseFirestore) {

    /**
     * Information about a company or 'Fleet'
     */

    class FleetData(
        internal var id: UUID = UUID.randomUUID(), // identifier of fleet
        internal var name: String = "", // name of the company
        private var owner: User, // identifier of owner
        private var managers: ArrayList<User> = ArrayList(), // managers of the fleet
        private var members: ArrayList<User> = ArrayList() // employees within the fleet aside from the owner and managers
    ){
        /**
         * @param [currentUser] the user that is currently logged in
         * @return whether or not the current user is the fleetOwner
         */
        fun isOwner(currentUser: User) :Boolean{
            return owner.equals(currentUser)
        }
        /**
         * @return An [ArrayList] of [User] that are non manager members
         */
        fun members(): ArrayList<User> {
            return members
        }
        /**
         * @return An [ArrayList] of [User] of manager members
         */
        fun managers(): ArrayList<User> {
            return this.managers
        }
        /**
         * @param currentUser the current [User] that is logged in
         */
        fun addMember(currentUser: User, newUser:User){
            if(isOwner(currentUser)) {
                members.add(newUser)
            }
        }
        /**
         * @param someUser the [User] that is to be added to the list of managers
         */
        fun isManager(someUser: User): Boolean {
            if(managers().isEmpty().not()){
                managers.forEach(){
                    if(someUser.equals(it)){
                        return true
                    }
                }
            }
            return false
        }
        /**
         *
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
         *
         */
        fun makeManager(toBeManager: User){
            if(this.isManager(toBeManager)){

            }else if(this.isMember(toBeManager)){
                this.managers.remove(toBeManager)
            }else{
                managers.add(toBeManager)
            }
        }

    }


    data class Job(
        internal var id: UUID = UUID.randomUUID(), // identifier of job
        internal var jobName: String = "", // display name of the job
        internal var fleet: UUID = UUID.randomUUID(), // identifier of fleet assigned to
        internal var location: Location, // location of job
        internal var employees: List<com.example.teamsklent_electricvehicles_2023.User> = ArrayList(), // list of employees tasked with the job
        internal var completed: Boolean // Is the job completed
    )

    data class Location(
        internal var name: String,
        internal var lat: Double,
        internal var lon: Double
    )

    data class FleetEquipment(

        internal var equipment: ArrayList<Equipment>
    )
}