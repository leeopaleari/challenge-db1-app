package br.com.fiap.mentora.screens.auth.signUp.navigation

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.screens.auth.signIn.navigation.SignInDestination
import br.com.fiap.mentora.screens.auth.signIn.navigation.signInGraph

object AuthDestination : MentoraNavigationDestination {
    override val route = "auth_route"
    override val destination = "auth_destination"
}

fun NavGraphBuilder.authGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>,
) {
    navigation(route = AuthDestination.route, startDestination = SignInDestination.route) {

        signInGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )

        signUpGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
        signUpAboutYouGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
        yourHabilitiesGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility
        )
    }
}