package com.osao.moviecleanandroid.data.repository

import com.osao.moviecleanandroid.data.mapper.toUI
import com.osao.moviecleanandroid.data.network.MovieApi
import com.osao.moviecleanandroid.domain.popular.models.PopularResponseUI
import com.osao.moviecleanandroid.domain.popular.repository.PopularRepository
import javax.inject.Inject

class PopularRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
): PopularRepository {
    override suspend fun getPopularMovies(): PopularResponseUI {
        return movieApi.getPopularMovies().toUI()
    }
}