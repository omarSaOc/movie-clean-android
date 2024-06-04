package com.osao.moviecleanandroid.data.repository

import com.osao.moviecleanandroid.data.mapper.toUI
import com.osao.moviecleanandroid.data.network.MovieApi
import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieResponseUI
import com.osao.moviecleanandroid.domain.upcoming.repository.UpcomingRepository
import javax.inject.Inject

class UpcomingRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
): UpcomingRepository {
    override suspend fun getUpcomingMovies(): UpcomingMovieResponseUI {
        return movieApi.getUpcomingMovies().toUI()
    }

}