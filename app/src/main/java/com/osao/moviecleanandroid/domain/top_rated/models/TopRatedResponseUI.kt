package com.osao.moviecleanandroid.domain.top_rated.models

data class TopRatedResponseUI(
    val page: Int,
    val results: List<TopRatedMovieUI>,
    val total_pages: Int,
    val total_results: Int
)