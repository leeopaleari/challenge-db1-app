package br.com.fiap.mentora.navigation.auth

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.fiap.mentora.navigation.profile.profileRegisterRoute
import br.com.fiap.mentora.ui.screens.auth.signUp.SignUpScreen

const val signUpRoute = "signUpRoute"

fun NavHostController.navigateToSignUpScreen() {
    navigate(signUpRoute)
}

fun NavGraphBuilder.signUpScreen(
    onPopBackStack: () -> Unit,
    onNavigateToProfileScreen: () -> Unit
) {
    composable(signUpRoute,
        enterTransition = {
            when (initialState.destination.route) {
                signInRoute -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                profileRegisterRoute -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }, exitTransition = {
            when (targetState.destination.route) {
                signInRoute -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                profileRegisterRoute -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }) {
        SignUpScreen(
            onPopBackStack = onPopBackStack,
            onNavigateToProfileScreen = onNavigateToProfileScreen
        )
    }
}
