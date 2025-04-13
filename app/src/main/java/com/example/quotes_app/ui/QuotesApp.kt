package com.example.quotes_app.ui

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.rememberNavController
import com.example.quotes_app.ui.components.BottomNavigationBar
import com.example.quotes_app.ui.theme.QuotesAppTheme
import com.example.quotes_app.utils.TopLevelDestinations

@Composable
fun QuotesApp(modifier: Modifier) {
    QuotesAppTheme {
        val navController = rememberNavController()
        val previousDestination = remember { mutableStateOf<NavDestination?>(null) }
        val currentEntry = navController.currentBackStackEntryFlow.collectAsState(initial = null)

//        val currentDestination: NavDestination? =
//            currentEntry.value?.destination.also { navDestination ->
//                if (navDestination != null) {
//                    previousDestination.value = navDestination
//                }
//            } ?: previousDestination.value

//        val currentTopLevelDestination: TopLevelDestinations? =
//            TopLevelDestinations.entries.firstOrNull { destination ->
//                currentDestination?.hasRoute(route = destination.route::class) == true
//            }

        Scaffold(modifier = modifier.fillMaxSize(),
            topBar = {},
            bottomBar = {
            BottomNavigationBar(TopLevelDestinations.entries, navController)
        }) { innerPadding ->
            AppNavigationGraph(modifier.padding(innerPadding).fillMaxSize()
                .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()), navController )
        }
    }
}