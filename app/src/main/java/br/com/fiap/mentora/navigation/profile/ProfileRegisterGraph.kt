package br.com.fiap.mentora.navigation.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

fun NavGraphBuilder.profileRegisterGraph(
    onPopBackStack: () -> Unit,
    onNavigateToYourHabilitiesScreen: () -> Unit,
) {
    navigation(route = "profileRegisterGraph", startDestination = profileRegisterRoute) {
        profileRegisterScreen(
            navigateToYourHabilitiesScreen = onNavigateToYourHabilitiesScreen,
            onPopBackStack = onPopBackStack
        )
        yourHabilitiesScreen(
            onPopBackStack = onPopBackStack
        )
    }
}