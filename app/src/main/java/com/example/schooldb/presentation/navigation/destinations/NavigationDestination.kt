package com.example.schooldb.presentation.navigation.destinations

import androidx.navigation.NamedNavArgument

fun interface NavigationDestination {

    fun route(): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()
}