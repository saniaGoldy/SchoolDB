package com.example.schooldb.presentation.navigation.destinations.login

import com.example.schooldb.presentation.navigation.destinations.NavigationDestination

object HomeDestination  : NavigationDestination {
    private const val HOME_DESTINATION = "home"
    override fun route(): String = HOME_DESTINATION
}