package br.com.fiap.mentora.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentora.screens.app.favorites.destination.favoritesGraph
import br.com.fiap.mentora.screens.app.home.destination.HomeDestination
import br.com.fiap.mentora.screens.app.home.destination.homeGraph
import br.com.fiap.mentora.screens.app.profile.navigation.profileGraph
import br.com.fiap.mentora.screens.app.search.destination.searchGraph
import br.com.fiap.mentora.screens.auth.signIn.navigation.SignInDestination
import br.com.fiap.mentora.screens.auth.signIn.navigation.signInGraph
import br.com.fiap.mentora.screens.auth.signUp.AboutYouRegisterScreen
import br.com.fiap.mentora.screens.auth.signUp.navigation.aboutYouRegisterGraph
import br.com.fiap.mentora.screens.auth.signUp.navigation.signUpGraph
import br.com.fiap.mentora.screens.auth.signUp.navigation.yourHabilitiesGraph

@Composable
fun MentoraNavHost(
    bottomBarVisibility: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = SignInDestination.route
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

        signInGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )

        signUpGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
        aboutYouRegisterGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
        yourHabilitiesGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
    }
}