package br.com.fiap.mentora.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.fiap.mentora.ui.screens.auth.signUp.SignUpScreen

const val signUpRoute = "signUpRoute"

fun NavHostController.navigateToSignUpScreen() {
    navigate(signUpRoute)
}

fun NavGraphBuilder.signUpScreen(
    onPopBackStack: () -> Unit,
    onNavigateToProfileScreen: () -> Unit
) {
    composable(signUpRoute) {
        SignUpScreen(
            onPopBackStack = onPopBackStack,
            onNavigateToProfileScreen = onNavigateToProfileScreen
        )
    }
}
