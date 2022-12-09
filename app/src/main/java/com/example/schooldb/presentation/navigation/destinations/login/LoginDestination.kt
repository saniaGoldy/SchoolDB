package com.example.schooldb.presentation.navigation.destinations.login

import com.example.schooldb.presentation.navigation.destinations.NavigationDestination

object LoginDestination : NavigationDestination {
    private const val LOGIN_DESTINATION = "login"
    override fun route(): String = LOGIN_DESTINATION
}