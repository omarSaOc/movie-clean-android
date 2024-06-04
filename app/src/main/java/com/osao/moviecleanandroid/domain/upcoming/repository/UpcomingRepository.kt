package com.osao.moviecleanandroid.domain.upcoming.repository

import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieResponseUI

interface UpcomingRepository {

    suspend fun getUpcomingMovies(): UpcomingMovieResponseUI
}