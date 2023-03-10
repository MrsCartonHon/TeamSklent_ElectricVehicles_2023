package com.example.teamsklent_electricvehicles_2023

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.compass, "Home")
    object Locate : NavigationItem("locate", R.drawable.compass, "Locate")
    object Log : NavigationItem("books", R.drawable.book_marker, "Log")
    object Account : NavigationItem("profile", R.drawable.account, "Account")
}