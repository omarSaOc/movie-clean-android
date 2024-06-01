package com.osao.moviecleanandroid.domain.popular.use_cases

import com.osao.moviecleanandroid.domain.popular.models.PopularResponseUI
import com.osao.moviecleanandroid.domain.popular.repository.PopularRepository
import javax.inject.Inject

class PopularUseCase @Inject constructor(
    private val repository: PopularRepository
) {
    suspend fun invoke(): PopularResponseUI {
        return repository.getPopularMovies()
    }
}