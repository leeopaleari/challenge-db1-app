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
import br.com.fiap.mentora.screens.auth.signIn.navigation.SignInDestination
import br.com.fiap.mentora.screens.auth.signUp.SignUpScreen
import br.com.fiap.mentora.screens.auth.signUp.viewmodel.SignUpViewModel

object SignUpDestination : MentoraNavigationDestination {
    override val route = "signup_route"
    override val destination = "signup_destination"
}

fun NavGraphBuilder.signUpGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>
) {
    composable(
        SignUpDestination.route,
        enterTransition = {
            when (initialState.destination.route) {
                SignUpDestination.route -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                AboutYouRegisterDestination.route -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }, exitTransition = {
            when (targetState.destination.route) {
                SignInDestination.route -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                AboutYouRegisterDestination.route -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }
    ) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = false
        }
        val signUpBackStackEntry = remember {
            navController.getBackStackEntry(SignUpFlowDestination.route)
        }
        val signUpViewModel: SignUpViewModel = hiltViewModel(signUpBackStackEntry);
        SignUpScreen(
            onPopBackStack = {
                navController.navigateUp();
            },
            onNavigateToProfileScreen = {
                navController.navigate(AboutYouRegisterDestination.route)
            },
            viewModel = signUpViewModel
        )
    }


}
