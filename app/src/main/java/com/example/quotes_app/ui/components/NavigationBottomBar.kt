package com.example.quotes_app.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.quotes_app.ui.navigationToActions
import com.example.quotes_app.utils.TopLevelDestinations

@Composable
fun RowScope.NavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    label: @Composable (() -> Unit)? = null
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        alwaysShowLabel = alwaysShowLabel,
        icon = if (selected) selectedIcon else icon,
        label = label,
    )
}

@Composable
fun BottomNavigationBar(topLevelDestinations: List<TopLevelDestinations>,
                        navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar  {
        topLevelDestinations.forEach { destination ->
            NavigationItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(destination.baseRoute::class) } == true,
                onClick = { navigationToActions(navController, destination) },
                modifier = Modifier,
                icon = { Icon(imageVector = destination.unSelectedIcon, contentDescription = destination.label) },
                selectedIcon = { Icon(imageVector = destination.selectedIcon, contentDescription = destination.label) },
                label = { Text(destination.label) }
            )
        }
    }
}