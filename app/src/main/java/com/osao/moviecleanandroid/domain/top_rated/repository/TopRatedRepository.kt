package com.osao.moviecleanandroid.domain.top_rated.repository

import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedResponseUI

interface TopRatedRepository {
    suspend fun getTopRatedMovies(): TopRatedResponseUI
}