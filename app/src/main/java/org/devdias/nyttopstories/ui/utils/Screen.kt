package org.devdias.nyttopstories.ui.utils

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
    object ArtsScreen: Screen("arts_screen")
    object TechScreen: Screen("tech_screen")
    object MoviesScreen: Screen("movies_screen")
    object FashionScreen: Screen("fashion_screen")
}
