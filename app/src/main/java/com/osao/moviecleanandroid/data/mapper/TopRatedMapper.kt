package com.osao.moviecleanandroid.data.mapper

import com.osao.moviecleanandroid.data.network.models.response.TopRatedMovie
import com.osao.moviecleanandroid.data.network.models.response.TopRatedResponse
import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedMovieUI
import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedResponseUI

fun TopRatedResponse.toUI() = TopRatedResponseUI(
    page = page,
    results = results.map { it.toUI() },
    total_pages = total_pages,
    total_results = total_results
)

fun TopRatedMovie.toUI() = TopRatedMovieUI(
    adult = adult,
    backdrop_path = backdrop_path,
    genre_ids = genre_ids,
    id = id,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count
)