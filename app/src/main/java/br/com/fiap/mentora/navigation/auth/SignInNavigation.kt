package br.com.fiap.mentora.navigation.auth

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.ui.screens.auth.signIn.SignInScreen

const val signInRoute = "signin_route"


fun NavGraphBuilder.signInScreen(
    onNavigateToSignUpScreen: () -> Unit,
    onNavigateToAppScaffold: () -> Unit,
) {
    composable(signInRoute,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(durationMillis = 300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(durationMillis = 300)
            )
        }) {
        SignInScreen(
            onNavigateToSignUpScreen = onNavigateToSignUpScreen,
            onNavigateToAppScaffold = onNavigateToAppScaffold
        )
    }
}
