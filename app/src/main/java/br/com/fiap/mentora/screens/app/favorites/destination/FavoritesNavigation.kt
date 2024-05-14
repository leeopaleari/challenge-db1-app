package br.com.fiap.mentora.screens.app.favorites.destination

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.screens.app.favorites.FavoritesScreen
import br.com.fiap.mentora.screens.app.search.SearchScreen

object FavoritesDestination : MentoraNavigationDestination {
    override val route = "favorites_route"
    override val destination = "favorites_destination"
}
fun NavGraphBuilder.favoritesGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>,
) {
    composable(route = FavoritesDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
        }
        FavoritesScreen()
    }
}