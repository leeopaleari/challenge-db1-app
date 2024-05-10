package br.com.fiap.mentora.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.screens.auth.signIn.SignInScreen

const val signInRoute = "signInRoute"


fun NavGraphBuilder.signInScreen(
    onNavigateToSignUpScreen: () -> Unit,
) {
    composable(signInRoute) {
        SignInScreen(
            onNavigateToSignUpScreen = onNavigateToSignUpScreen
        )
    }
}
