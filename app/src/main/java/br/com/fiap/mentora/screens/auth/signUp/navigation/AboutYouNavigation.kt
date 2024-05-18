package br.com.fiap.mentora.screens.auth.signUp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.core.navigation.sharedViewModel
import br.com.fiap.mentora.screens.auth.signUp.AboutYouRegisterScreen
import br.com.fiap.mentora.screens.auth.signUp.viewmodel.SignUpViewModel

object SignUpAboutYouDestination : MentoraNavigationDestination {
    override val route = "aboutyou_route"
    override val destination = "aboutyou_destination"
}

fun NavGraphBuilder.signUpAboutYouGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>
) {
    composable(
        SignUpAboutYouDestination.route,
        enterTransition = {
            when (initialState.destination.route) {
                SignUpDestination.route -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                YourHabilitiesNavigation.route -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }, exitTransition = {
            when (targetState.destination.route) {
                SignUpDestination.route -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                YourHabilitiesNavigation.route -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = false
        }
        val signUpViewModel = it.sharedViewModel<SignUpViewModel>(navController)

        AboutYouRegisterScreen(
            onPopBackStack = {
                navController.navigateUp();
            },
            navigateToYourHabilitiesScreen = {
                navController.navigate(YourHabilitiesNavigation.route)
            },
            viewModel = signUpViewModel
        )
    }
}