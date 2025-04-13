package com.example.quotes_app.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable data object HomeBaseRoute

@Serializable data object HomeRoute

@Serializable data object SavedRoute

@Serializable data class DetailsRoute(val id: Int)

enum class TopLevelDestinations(
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val label: String,
    val route: Any,
    val baseRoute: Any = route
) {
    Home(
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        label = "Home",
        route = HomeRoute,
        baseRoute = HomeBaseRoute
    ),
    Saved(
        selectedIcon = Icons.Filled.Favorite,
        unSelectedIcon = Icons.Outlined.FavoriteBorder,
        label = "Saved",
        route = SavedRoute
    )
}