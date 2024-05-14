package br.com.fiap.mentora

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentora.navigation.MentoraNavHost
import br.com.fiap.mentora.navigation.MentoraTopLevelNavigation
import br.com.fiap.mentora.navigation.TOP_LEVEL_DESTINATIONS
import br.com.fiap.mentora.navigation.TopLevelDestination
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.MentoraTheme
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextContrast


//data class BottomNavigationItem(
//    val title: String,
//    val route: String,
//    val selectedIcon: ImageVector,
//    val unselectedIcon: ImageVector,
//    val badgeCount: Int? = null
//)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MentoraApp() {
    MentoraTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.onBackground,
        ) {
            val navController = rememberNavController()
            val mentoraTopLevelNavigation = remember(navController) {
                MentoraTopLevelNavigation(navController)
            }
            val bottomBarVisibility = rememberSaveable {
                mutableStateOf(true)
            }

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            Scaffold(
                containerColor = BackgroundDark,
                contentColor = MaterialTheme.colorScheme.onBackground,
                bottomBar = {
                    Box {
                        AnimatedVisibility(
                            visible = bottomBarVisibility.value,
                            enter = slideInVertically(initialOffsetY = { it }),
                            exit = slideOutVertically(targetOffsetY = { it }),
                            content = {
                                MentoraBottomBar(
                                    onNavigateToTopLevelDestination = mentoraTopLevelNavigation::navigateTo,
                                    currentDestination = currentDestination,
                                )
                            }
                        )
                    }
                }
            ) { padding ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                ) {
                    MentoraNavHost(
                        navController = navController,
                        bottomBarVisibility = bottomBarVisibility,
                        modifier = Modifier
                            .padding(padding)
                            .consumeWindowInsets(padding)
                            .zIndex(1f)
                    )
                }

            }
        }
    }
}

@Composable
private fun MentoraBottomBar(
    currentDestination: NavDestination?,
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit,
) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        NavigationBar(
//            modifier = Modifier.windowInsetsPadding(
//                WindowInsets.safeDrawing.only(
//                    WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
//                )
//            ),
            containerColor = BackgroundDark,
//            tonalElevation = 0.dp
        ) {
            TOP_LEVEL_DESTINATIONS.forEach { destination ->
                val selected =
                    currentDestination?.hierarchy?.any { it.route == destination.route } == true

                NavigationBarItem(
                    selected = selected,
                    onClick =
                    {
                        onNavigateToTopLevelDestination(destination)
                    },
                    icon = {
                        Icon(
                            if (selected) {
                                destination.selectedIcon
                            } else {
                                destination.unselectedIcon
                            },
                            contentDescription = null
                        )
                    },
                    label = { Text(destination.iconText) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = TextContrast,
                        indicatorColor = PrimaryColor
                    )
                )
            }
        }
    }
}
//@Composable
//fun MentoraApp(
//    navController: NavController,
//) {
//    val navItems = listOf(
//        BottomNavigationItem(
//            title = "Início",
//            route = "home_screen",
//            selectedIcon = Icons.Filled.Home,
//            unselectedIcon = Icons.Outlined.Home
//        ),
//        BottomNavigationItem(
//            title = "Busca",
//            route = "search_screen",
//            selectedIcon = Icons.Filled.Search,
//            unselectedIcon = Icons.Outlined.Search
//        ),
//        BottomNavigationItem(
//            title = "Favoritos",
//            route = "favorites_screen",
//            selectedIcon = Icons.Filled.Favorite,
//            unselectedIcon = Icons.Outlined.FavoriteBorder
//        ),
//        BottomNavigationItem(
//            title = "Perfil",
//            route = "profile_screen",
//            selectedIcon = Icons.Filled.Person,
//            unselectedIcon = Icons.Outlined.Person
//        ),
//    )
//    Scaffold(
//        containerColor = BackgroundDark,
//        bottomBar = {
//            NavigationBar(
//                containerColor = BackgroundDark,
//                tonalElevation = 2.dp,
//                modifier = Modifier.height(100.dp)
//            ) {
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentDestination = navBackStackEntry?.destination
//
//                navItems.forEach { item ->
//                    val isCurrentDestinationEqualRoute =
//                        currentDestination?.hierarchy?.any { it.route == item.route }
//
//                    NavigationBarItem(
//                        selected = isCurrentDestinationEqualRoute == true,
//                        onClick = {
//                            navController.navigate(route = item.route) {
//                                popUpTo(navController.graph.findStartDestination().id) {
//                                    saveState = true
//                                }
//                                launchSingleTop = true
//                                restoreState = true
//                            }
//                        },
//                        label = {
//                            Text(text = item.title)
//                        },
//                        icon = {
//                            Icon(
//                                imageVector = if (isCurrentDestinationEqualRoute == true) item.selectedIcon else item.unselectedIcon,
//                                contentDescription = item.title
//                            )
//                        },
//                        colors = NavigationBarItemDefaults.colors(
//                            selectedIconColor = TextContrast,
//                            indicatorColor = PrimaryColor
//                        )
//                    )
//                }
//            }
//        }
//    ) { innerPadding ->
//        Box(modifier = Modifier.padding(innerPadding)) {
//            NavHost(
//                navController = navController as NavHostController,
//                startDestination = mainGraphRoute
//            ) {
//                mainGraph(navController)
//            }
//        }
//    }
//}
