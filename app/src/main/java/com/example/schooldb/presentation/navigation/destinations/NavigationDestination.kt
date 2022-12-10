package com.example.schooldb.presentation.navigation.destinations

import androidx.navigation.NamedNavArgument

fun interface NavigationDestination {

    /**
     * Use it to bind destination route to composable in nav graph
     *
     * Can be used to navigate to composable in case it doesn`t need any arguments
     */
    fun route(): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()
}