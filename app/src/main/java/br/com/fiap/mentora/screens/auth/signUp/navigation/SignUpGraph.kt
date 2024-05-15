package br.com.fiap.mentora.screens.auth.signUp.navigation

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination

object SignUpFlowDestination : MentoraNavigationDestination {
    override val route = "signupflow_route"
    override val destination = "signupflow_destination"
}

fun NavGraphBuilder.signUpFlowGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>,
) {
    navigation(route = SignUpFlowDestination.route, startDestination = SignUpDestination.route) {

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