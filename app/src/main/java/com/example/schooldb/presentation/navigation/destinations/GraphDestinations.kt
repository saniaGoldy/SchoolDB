package com.example.schooldb.presentation.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.schooldb.presentation.HomeScreen
import com.example.schooldb.presentation.login.LoginScreen
import com.example.schooldb.presentation.navigation.destinations.login.HomeDestination
import com.example.schooldb.presentation.navigation.destinations.login.LoginDestination

private val composableDestinations: Map<NavigationDestination, @Composable (NavBackStackEntry) -> Unit> =
    mapOf<NavigationDestination, @Composable (NavBackStackEntry) -> Unit>(
        LoginDestination to { LoginScreen() },
        HomeDestination to { HomeScreen(string = it.arguments?.getString(HomeDestination.USER_ID_PARAM)!!) }
    )

fun NavGraphBuilder.addComposableDestinations(navController: NavHostController) {
    composableDestinations.forEach { entry ->
        val destination = entry.key
        composable(destination.route(), destination.arguments) { navBackStackEntry ->
            entry.value(navBackStackEntry)
        }
    }
}