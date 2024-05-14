package br.com.fiap.mentora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentora.navigation.auth.authGraph
import br.com.fiap.mentora.ui.theme.MentoraTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MentoraTheme {
                MentoraApp()
            }
        }
    }
}

@Composable
fun MentoraApp() {
    val navController = rememberNavController()
    val navBarNavController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "auth_graph"
    ) {
        authGraph(navController)

        composable(
            route = "app_scaffold",
            content = {
                MentoraApp(navController = navBarNavController)
            }
        )
    }
}
