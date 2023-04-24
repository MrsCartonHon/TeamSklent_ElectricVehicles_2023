package com.example.teamsklent_electricvehicles_2023.models

import com.fasterxml.jackson.annotation.JsonBackReference

class FleetPermissions(@JsonBackReference var fleet: Fleet) {
    var canEditEmployees: ArrayList<FleetRoles> = ArrayList()
    var canEditEquipment: ArrayList<FleetRoles> = ArrayList()
    var canEditJobs: ArrayList<FleetRoles> = ArrayList()
    var canEditLocations : ArrayList<FleetRoles> = ArrayList()

    fun initFleetPermissions() {
        ownerInit(canEditEmployees)
        managerInit(canEditEquipment)
        memberInit(canEditJobs)
        memberInit(canEditLocations)
    }

    private fun ownerInit(permission: ArrayList<FleetRoles>){
        permission.add(FleetRoles.Owner)
    }
    private fun managerInit(permission: ArrayList<FleetRoles>){
        permission.add(FleetRoles.Owner)
        permission.add(FleetRoles.Manager)
    }
    private fun memberInit(permission: ArrayList<FleetRoles>){
        managerInit(permission)
        permission.add(FleetRoles.Member)
    }

//    fun changePermission(permissions: ArrayList<FleetRoles>, newPermissions: ArrayList<FleetRoles>){
//        permissions = newPermissions
//    }
}