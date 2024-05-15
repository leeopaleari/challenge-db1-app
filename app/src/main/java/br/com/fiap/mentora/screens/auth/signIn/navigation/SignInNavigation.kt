package br.com.fiap.mentora.screens.auth.signIn.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.screens.app.home.destination.HomeDestination
import br.com.fiap.mentora.screens.auth.signIn.SignInScreen
import br.com.fiap.mentora.screens.auth.signUp.navigation.SignUpDestination
import br.com.fiap.mentora.screens.auth.signUp.navigation.SignUpFlowDestination

object SignInDestination : MentoraNavigationDestination {
    override val destination = "signin_destination"
    override val route = "signin_route"
}

fun NavGraphBuilder.signInGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>,
) {
    composable(
        SignInDestination.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, tween(durationMillis = 300)
            )
        }, exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, tween(durationMillis = 300)
            )
        }
    ) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = false
        }

        SignInScreen(
            onNavigateToSignUpScreen = {
                navController.navigate(SignUpFlowDestination.route)
            },
            onNavigateToAppScaffold = {
                navController.navigate(HomeDestination.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}
