package br.com.fiap.mentora.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation

fun NavGraphBuilder.authGraph(
    onNavigateToSignUp: () -> Unit,
    onPopBackStack: () -> Unit,
    onNavigateToProfileScreen: () -> Unit,
) {
    navigation(route = "authGraph", startDestination = signInRoute) {
        signInScreen(
            onNavigateToSignUpScreen = onNavigateToSignUp
        )
        signUpScreen(
            onPopBackStack = onPopBackStack,
            onNavigateToProfileScreen = onNavigateToProfileScreen,
        )

    }
}
