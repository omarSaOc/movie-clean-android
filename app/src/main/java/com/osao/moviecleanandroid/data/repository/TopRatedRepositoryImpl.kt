package com.osao.moviecleanandroid.data.repository

import com.osao.moviecleanandroid.data.mapper.toUI
import com.osao.moviecleanandroid.data.network.MovieApi
import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedResponseUI
import com.osao.moviecleanandroid.domain.top_rated.repository.TopRatedRepository
import javax.inject.Inject

class TopRatedRepositoryImpl @Inject constructor(
private val movieApi: MovieApi
) : TopRatedRepository {
    override suspend fun getTopRatedMovies(): TopRatedResponseUI {
        return movieApi.getTopRatedMovies().toUI()
    }

}