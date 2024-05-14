package br.com.fiap.mentora.screens.auth.profile.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.fiap.mentora.screens.auth.profile.YourHabilitiesScreen

const val yourHabilitiesRoute = "your_habilities_route"

fun NavHostController.navigateYourHabilitiesScreen() {
    navigate(yourHabilitiesRoute)
}

fun NavGraphBuilder.yourHabilitiesScreen(
    onPopBackStack: () -> Unit
) {
    composable(
        yourHabilitiesRoute,
        enterTransition = {
            when (initialState.destination.route) {
                profileRegisterRoute -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }, exitTransition = {
            when (targetState.destination.route) {
                profileRegisterRoute -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }) {
        YourHabilitiesScreen(
            onPopBackStack = onPopBackStack
        )
    }
}