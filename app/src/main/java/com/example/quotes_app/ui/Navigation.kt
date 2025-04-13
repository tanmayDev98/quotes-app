package com.example.quotes_app.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.example.quotes_app.utils.TopLevelDestinations

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(route = TopLevelDestinations.Home.route, navOptions)
fun NavController.navigateToAdd(navOptions: NavOptions) = navigate(route = TopLevelDestinations.Saved.route, navOptions)

fun navigationToActions(navController: NavController, destinations: TopLevelDestinations) {
    val navOptions = navOptions {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    when(destinations) {
        TopLevelDestinations.Home -> navController.navigateToHome(navOptions)
        TopLevelDestinations.Saved -> navController.navigateToAdd(navOptions)
    }
}