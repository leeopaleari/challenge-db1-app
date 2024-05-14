package br.com.fiap.mentora.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.fiap.mentora.screens.app.favorites.FavoritesScreen
import br.com.fiap.mentora.screens.app.home.HomeScreen
import br.com.fiap.mentora.screens.app.profile.ProfileScreen
import br.com.fiap.mentora.screens.app.search.SearchScreen

const val mainGraphRoute = "main_graph"
fun NavGraphBuilder.mainGraph(
    navController: NavController
) {
    navigation(route = mainGraphRoute, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen(
                onLogout = {
                    navController.navigate("auth_graph")
                }
            )
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