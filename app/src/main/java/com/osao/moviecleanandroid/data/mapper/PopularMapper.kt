package com.osao.moviecleanandroid.data.mapper

import com.osao.moviecleanandroid.data.network.models.response.PopularMovie
import com.osao.moviecleanandroid.data.network.models.response.PopularResponse
import com.osao.moviecleanandroid.domain.popular.models.PopularMovieUI
import com.osao.moviecleanandroid.domain.popular.models.PopularResponseUI

fun PopularResponse.toUI() = PopularResponseUI(
    page = page,
    results = results.map { it.toUI() },
    total_pages = total_pages,
    total_results = total_results
)

fun PopularMovie.toUI() = PopularMovieUI(
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