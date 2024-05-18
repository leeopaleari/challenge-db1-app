package br.com.fiap.mentora.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.fiap.mentora.screens.app.favorites.destination.favoritesGraph
import br.com.fiap.mentora.screens.app.home.navigation.homeGraph
import br.com.fiap.mentora.screens.app.profile.navigation.profileGraph
import br.com.fiap.mentora.screens.app.search.destination.searchGraph
import br.com.fiap.mentora.screens.auth.signUp.navigation.AuthDestination
import br.com.fiap.mentora.screens.auth.signUp.navigation.authGraph

@Composable
fun MentoraNavHost(
    bottomBarVisibility: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AuthDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
        searchGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
        favoritesGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
        profileGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )

        authGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }

    return hiltViewModel(parentEntry)
}