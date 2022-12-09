package com.example.schooldb.presentation.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.schooldb.presentation.HomeScreen
import com.example.schooldb.presentation.login.LoginScreen
import com.example.schooldb.presentation.navigation.destinations.login.HomeDestination
import com.example.schooldb.presentation.navigation.destinations.login.LoginDestination

private val composableDestinations: Map<NavigationDestination, @Composable () -> Unit> =
    mapOf<NavigationDestination, @Composable () -> Unit>(
        LoginDestination to { LoginScreen() },
        HomeDestination to { HomeScreen(string = "ss")}
    )

fun NavGraphBuilder.addComposableDestinations(navController: NavHostController) {
    composableDestinations.forEach { entry ->
        val destination = entry.key
        composable(destination.route(), destination.arguments) {
            entry.value()
        }
    }
}