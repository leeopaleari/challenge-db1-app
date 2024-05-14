package br.com.fiap.mentora.screens.app.search.destination

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.screens.app.home.HomeScreen
import br.com.fiap.mentora.screens.app.search.SearchScreen


object SearchDestination : MentoraNavigationDestination {
    override val route = "search_route"
    override val destination = "search_destination"
}

fun NavGraphBuilder.searchGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>,
) {
    composable(route = SearchDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
        }
        SearchScreen()
    }
}