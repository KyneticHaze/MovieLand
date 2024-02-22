package com.example.movieland.ui.screens.home_screen.main_screen

import com.example.movieland.domain.model.Media

data class MainUIState(

    val popularMoviesPage: Int = 1,
    val topRatedMoviesPage: Int = 1,
    val nowPlayingMoviesPage: Int = 1,

    val popularTvSeriesPage: Int = 1,
    val topRatedTvSeriesPage: Int = 1,

    val trendingAllMediaPage: Int = 1,

    val error: String = "",
    val isRefresh: Boolean = false,
    val isLoading: Boolean = false,

    val popularMediaListModel : List<Media> = emptyList(),
    val topRatedMediaListModel : List<Media> = emptyList(),
    val nowPlayingMediaListModel : List<Media> = emptyList(),

    val popularTvSeriesList : List<Media> = emptyList(),
    val topRatedTvSeriesList : List<Media> = emptyList(),

    val trendingAllMediaListModel : List<Media> = emptyList(),
)
