package com.osao.moviecleanandroid.domain.top_rated.use_cases

import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedResponseUI
import com.osao.moviecleanandroid.domain.top_rated.repository.TopRatedRepository
import javax.inject.Inject

class TopRatedUseCase @Inject constructor(
    private val repository: TopRatedRepository
) {
    suspend fun invoke(): TopRatedResponseUI {
        return repository.getTopRatedMovies()
    }
}