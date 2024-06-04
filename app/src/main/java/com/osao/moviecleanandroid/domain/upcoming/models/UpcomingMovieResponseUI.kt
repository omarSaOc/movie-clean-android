package com.osao.moviecleanandroid.domain.upcoming.models

data class UpcomingMovieResponseUI(
    val dates: DatesUI,
    val page: Int,
    val results: List<UpcomingMovieUI>,
    val total_pages: Int,
    val total_results: Int
)