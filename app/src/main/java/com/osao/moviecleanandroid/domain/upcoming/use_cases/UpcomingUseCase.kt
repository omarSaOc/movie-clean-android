package com.osao.moviecleanandroid.domain.upcoming.use_cases

import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieResponseUI
import com.osao.moviecleanandroid.domain.upcoming.repository.UpcomingRepository
import javax.inject.Inject

class UpcomingUseCase @Inject constructor(
    private val repository: UpcomingRepository
) {
    suspend fun invoke(): UpcomingMovieResponseUI {
        return repository.getUpcomingMovies()
    }
}