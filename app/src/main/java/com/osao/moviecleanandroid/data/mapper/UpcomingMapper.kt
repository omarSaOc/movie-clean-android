package com.osao.moviecleanandroid.data.mapper

import com.osao.moviecleanandroid.data.network.models.response.Dates
import com.osao.moviecleanandroid.data.network.models.response.UpcomingMovie
import com.osao.moviecleanandroid.data.network.models.response.UpcomingResponse
import com.osao.moviecleanandroid.domain.upcoming.models.DatesUI
import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieResponseUI
import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieUI

fun UpcomingResponse.toUI(): UpcomingMovieResponseUI {
    return UpcomingMovieResponseUI(
        dates = dates.toUI(),
        page = page,
        results = results.map { it.toUI() },
        total_pages = total_pages,
        total_results = total_results
    )
}

fun Dates.toUI(): DatesUI {
    return DatesUI(
        maximum = maximum,
        minimum = minimum
    )
}

fun UpcomingMovie.toUI(): UpcomingMovieUI {
    return UpcomingMovieUI(
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
}