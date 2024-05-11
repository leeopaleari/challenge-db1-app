package br.com.fiap.mentora.navigation.profile

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.fiap.mentora.ui.screens.auth.profile.YourHabilitiesScreen

const val yourHabilitiesRoute = "yourHabilitiesRoute"

fun NavHostController.navigateYourHabilitiesScreen() {
    navigate(yourHabilitiesRoute)
}

fun NavGraphBuilder.yourHabilitiesScreen(
    onPopBackStack: () -> Unit
) {
    composable(yourHabilitiesRoute,
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