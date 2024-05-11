package br.com.fiap.mentora.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.fiap.mentora.ui.screens.app.favorites.FavoritesScreen
import br.com.fiap.mentora.ui.screens.app.home.HomeScreen
import br.com.fiap.mentora.ui.screens.app.profile.ProfileScreen
import br.com.fiap.mentora.ui.screens.app.search.SearchScreen

const val mainGraphRoute = "main_graph"
fun NavGraphBuilder.mainGraph(
    navController: NavController
) {
    navigation(route = mainGraphRoute, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen()
        }
        composable("search_screen") {
            SearchScreen()
        }
        composable("favorites_screen") {
            FavoritesScreen()
        }
        composable("profile_screen") {
            ProfileScreen()
        }

    }
}