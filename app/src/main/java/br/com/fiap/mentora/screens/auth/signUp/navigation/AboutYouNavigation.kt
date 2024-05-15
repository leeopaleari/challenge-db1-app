package br.com.fiap.mentora.screens.auth.signUp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.screens.auth.signUp.AboutYouRegisterScreen
import br.com.fiap.mentora.screens.auth.signUp.viewmodel.SignUpViewModel

object AboutYouRegisterDestination : MentoraNavigationDestination {
    override val route = "aboutyouregister_route"
    override val destination = "aboutyouregister_destination"
}

fun NavGraphBuilder.aboutYouRegisterGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>
) {
    composable(
        AboutYouRegisterDestination.route,
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
        val signUpBackStackEntry = remember {
            navController.getBackStackEntry(SignUpFlowDestination.route)
        }
        val signUpViewModel: SignUpViewModel = hiltViewModel(signUpBackStackEntry);
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