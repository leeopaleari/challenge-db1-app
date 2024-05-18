package br.com.fiap.mentora.screens.auth.signUp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.core.navigation.sharedViewModel
import br.com.fiap.mentora.screens.app.home.navigation.HomeDestination
import br.com.fiap.mentora.screens.auth.signUp.YourHabilitiesScreen
import br.com.fiap.mentora.screens.auth.signUp.viewmodel.SignUpViewModel

object YourHabilitiesNavigation : MentoraNavigationDestination {
    override val route = "yourhabilities_route"
    override val destination = "yourhabilities_destination"
}

fun NavGraphBuilder.yourHabilitiesGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>
) {
    composable(
        YourHabilitiesNavigation.route,
        enterTransition = {
            when (initialState.destination.route) {
                SignUpAboutYouDestination.route -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }, exitTransition = {
            when (targetState.destination.route) {
                SignUpAboutYouDestination.route -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }) {

        LaunchedEffect(null) {
            bottomBarVisibility.value = false
        }

        val signUpViewModel = it.sharedViewModel<SignUpViewModel>(navController)


        YourHabilitiesScreen(
            onPopBackStack = {
                navController.navigateUp()
            },
            onNavigateToHome = {
                navController.navigate(HomeDestination.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            viewModel = signUpViewModel
        )
    }
}