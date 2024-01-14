package com.example.movieland.ui.navigation

sealed class Screens(val screen : String) {
    data object Splash : Screens("splash_screen")
    data object Intro : Screens("intro_screen")
    data object Login : Screens("login_screen")
    data object Register : Screens("register_screen")
    data object Main : Screens("main_screen")
    data object Detail : Screens("detail_screen")
    data object Upcoming : Screens("upcoming_screen")
    data object TopRated : Screens("top_rated_screen")
    data object Playing  : Screens("playing_screen")
    data object Popular : Screens("popular_screen")
    data object Profile : Screens("profile_screen")
    data object Search : Screens("search_screen")
}