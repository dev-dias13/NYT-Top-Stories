package org.devdias.nyttopstories.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.devdias.nyttopstories.ui.sections.ArtsScreen
import org.devdias.nyttopstories.ui.sections.FashionScreen
import org.devdias.nyttopstories.ui.sections.MoviesScreen
import org.devdias.nyttopstories.ui.sections.TechScreen
import org.devdias.nyttopstories.ui.utils.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.ArtsScreen.route) {
            ArtsScreen()
        }
        composable(route = Screen.TechScreen.route) {
            TechScreen()
        }
        composable(route = Screen.MoviesScreen.route) {
            MoviesScreen()
        }
        composable(route = Screen.FashionScreen.route) {
            FashionScreen()
        }
    }
}