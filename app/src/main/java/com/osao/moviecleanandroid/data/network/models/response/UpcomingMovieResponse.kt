package com.osao.moviecleanandroid.data.network.models.response

data class UpcomingMovieResponse(
    val dates: Dates,
    val page: Int,
    val results: List<UpcomingMovie>,
    val total_pages: Int,
    val total_results: Int
)