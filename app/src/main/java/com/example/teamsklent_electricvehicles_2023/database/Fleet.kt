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
         *@param [currentUser] The user currently is the fleet owner for verification
         */
        fun isOwner(currentUser: User) :Boolean{
            return (currentUser.id == owner.id && currentUser.password == owner.password)
        }

        /**
         * @return Returns all employees of a Fleet
         */
        fun members(): ArrayList<User> {
            return this.members
        }

        /**
         * Adds a new [User] Employee to the Fleet
         * @param [currentUser] uses the [isOwner] method for verification
         * @param [newUser] The new employee to be added to the fleet
         */
        fun addMember(currentUser: User, newUser:User){
            if(isOwner(currentUser)) {
                members.add(newUser)
            } else{
                throw Exception("Invalid User")
            }
        }

        /**
         * removes a specified [User] from the Fleet employee list
         * @param [currentUser] uses the [isOwner] method for verification
         * @param [oldUser] Removes a [User] from the Fleet employee list
         * @exception NoSuchElementException The [oldUser] [User] does not exist
         * @throws NoSuchElementException you're a bum
         */
        fun removeMember(currentUser: User, oldUser:User){
            if(isOwner(currentUser)) {
                try {
                    members.remove(oldUser)
                }catch(exception: NoSuchElementException){
                    exception.localizedMessage
                }
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