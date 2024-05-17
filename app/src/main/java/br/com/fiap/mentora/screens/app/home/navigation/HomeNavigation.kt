package br.com.fiap.mentora.screens.app.home.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.screens.app.home.HomeScreen

object HomeDestination : MentoraNavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}
fun NavGraphBuilder.homeGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>,
) {
    composable(route = HomeDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
        }
        HomeScreen()
    }
}