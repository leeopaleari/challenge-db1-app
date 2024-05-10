package br.com.fiap.mentora.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import br.com.fiap.mentora.navigation.profile.profileRegisterScreen
import br.com.fiap.mentora.navigation.profile.yourHabilitiesRoute
import br.com.fiap.mentora.navigation.profile.yourHabilitiesScreen

fun NavGraphBuilder.authGraph(
    onNavigateToSignUp: () -> Unit,
    onPopBackStack: () -> Unit,
    onNavigateToProfileScreen: () -> Unit,
    onNavigateToYourHabilitiesScreen: () -> Unit,
) {
    navigation(route = "authGraph", startDestination = yourHabilitiesRoute) {
        signInScreen(
            onNavigateToSignUpScreen = onNavigateToSignUp
        )
        signUpScreen(
            onPopBackStack = onPopBackStack,
            onNavigateToProfileScreen = onNavigateToProfileScreen,
        )
        profileRegisterScreen(
            navigateToYourHabilitiesScreen = onNavigateToYourHabilitiesScreen
        )
        yourHabilitiesScreen()
    }
}
