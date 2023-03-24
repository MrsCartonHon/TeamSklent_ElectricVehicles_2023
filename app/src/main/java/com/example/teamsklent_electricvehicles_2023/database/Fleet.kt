package com.example.teamsklent_electricvehicles_2023.database

import com.example.teamsklent_electricvehicles_2023.database.Users.User
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

abstract class Fleet(val db : FirebaseFirestore) {

    /**
     * Information about a company or 'Fleet'
     *
     */


    class FleetData(
        internal var id: UUID = UUID.randomUUID(), // identifier of fleet
        internal var name: String = "", // name of the company
        internal var owner: User, // identifier of owner
        private var members: ArrayList<User> = ArrayList() // employees within the fleet aside from the owner
    ){
        /**
         *
         */
        fun isOwner(currentUser: User) :Boolean{
            return (currentUser.id == owner.id && currentUser.password == owner.password)
        }
        fun members(): ArrayList<User> {
            return this.members
        }
        fun addMember(currentUser: User, newUser:User){
            if(isOwner(currentUser)) {
                members.add(newUser)
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
    ){

    }

    data class Location(
        internal var name: String,
        internal var lat: Double,
        internal var lon: Double
    )

    data class FleetEquipment(

        internal var equipment: ArrayList<Equipment>
    )
}