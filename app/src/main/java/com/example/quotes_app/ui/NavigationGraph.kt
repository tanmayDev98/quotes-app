package com.example.quotes_app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.quotes_app.ui.details.DetailsScreen
import com.example.quotes_app.ui.home.HomeScreen
import com.example.quotes_app.ui.home.HomeViewModel
import com.example.quotes_app.ui.saved.SavedScreen
import com.example.quotes_app.ui.saved.SavedViewModel
import com.example.quotes_app.utils.DetailsRoute
import com.example.quotes_app.utils.HomeBaseRoute
import com.example.quotes_app.utils.HomeRoute
import com.example.quotes_app.utils.SavedRoute

@Composable
fun AppNavigationGraph(modifier: Modifier = Modifier,
                       navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeBaseRoute) {
        navigation<HomeBaseRoute>(startDestination = HomeRoute) {
            composable<HomeRoute> {
//                val homeViewModel: HomeViewModel = viewModel(
//                    factory = HomeViewModel.provideFactory(
//                        quotesRepository = appContainer.quotesRepository
//                    )
//                )
                HomeScreen(modifier)
            }
            composable<DetailsRoute> {
                DetailsScreen()
            }
        }
        composable<SavedRoute> {
//            val savedViewModel: SavedViewModel = viewModel(
//                factory = SavedViewModel.providesFactory(
//                    quotesRepository = appContainer.quotesRepository
//                )
//            )
            SavedScreen(modifier)
        }
    }
}