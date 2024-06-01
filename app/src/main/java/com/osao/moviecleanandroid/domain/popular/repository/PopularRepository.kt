package com.osao.moviecleanandroid.domain.popular.repository

import com.osao.moviecleanandroid.domain.popular.models.PopularResponseUI

interface PopularRepository {
    suspend fun getPopularMovies(): PopularResponseUI
}