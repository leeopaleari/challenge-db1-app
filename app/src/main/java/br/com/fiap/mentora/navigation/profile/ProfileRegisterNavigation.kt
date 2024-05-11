package br.com.fiap.mentora.navigation.profile

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.fiap.mentora.navigation.auth.signInRoute
import br.com.fiap.mentora.navigation.auth.signUpRoute
import br.com.fiap.mentora.ui.screens.auth.profile.ProfileRegisterScreen
import br.com.fiap.mentora.ui.screens.auth.profile.YourHabilitiesScreen

const val profileRegisterRoute = "profileRegisterRoute"
const val yourHabilitiesRoute = "yourHabilitiesRoute"

fun NavHostController.navigateToProfileScreen() {
    navigate(profileRegisterRoute)
}

fun NavHostController.navigateYourHabilitiesScreen() {
    navigate(yourHabilitiesRoute)
}


fun NavGraphBuilder.profileRegisterScreen(
    navigateToYourHabilitiesScreen: () -> Unit,
    onPopBackStack: () -> Unit,

    ) {
    composable(profileRegisterRoute,
        enterTransition = {
            when (initialState.destination.route) {
                signUpRoute -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                yourHabilitiesRoute -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }, exitTransition = {
            when (targetState.destination.route) {
                signUpRoute -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

                yourHabilitiesRoute -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(durationMillis = 300)
                )

                else -> null
            }
        }) {
        ProfileRegisterScreen(
            onPopBackStack = onPopBackStack,
            navigateToYourHabilitiesScreen = navigateToYourHabilitiesScreen
        )
    }
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

//                yourHabilitiesRoute -> slideIntoContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Right,
//                    tween(durationMillis = 300)
//                )

                else -> null
            }
        }, exitTransition = {
            when (targetState.destination.route) {
                profileRegisterRoute -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(durationMillis = 300)
                )

//                yourHabilitiesRoute -> slideOutOfContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Left,
//                    tween(durationMillis = 300)
//                )

                else -> null
            }
        }) {
        YourHabilitiesScreen(
            onPopBackStack = onPopBackStack
        )
    }
}