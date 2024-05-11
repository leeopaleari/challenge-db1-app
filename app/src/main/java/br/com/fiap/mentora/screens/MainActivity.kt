package br.com.fiap.mentora.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentora.navigation.auth.authGraph
import br.com.fiap.mentora.navigation.profile.navigateToProfileScreen
import br.com.fiap.mentora.navigation.auth.navigateToSignUpScreen
import br.com.fiap.mentora.navigation.profile.navigateYourHabilitiesScreen
import br.com.fiap.mentora.navigation.profile.profileRegisterGraph
import br.com.fiap.mentora.ui.theme.MentoraTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MentoraTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "authGraph"
                ) {
                    authGraph(
                        onNavigateToSignUp = {
                            navController.navigateToSignUpScreen()
                        },
                        onPopBackStack = {
                            navController.popBackStack()
                        },
                        onNavigateToProfileScreen = {
                            navController.navigateToProfileScreen()
                        }
                    )

                    profileRegisterGraph(
                        onPopBackStack = {
                            navController.popBackStack()
                        },
                        onNavigateToYourHabilitiesScreen = {
                            navController.navigateYourHabilitiesScreen()
                        }
                    )
                }
            }
        }
    }


}
