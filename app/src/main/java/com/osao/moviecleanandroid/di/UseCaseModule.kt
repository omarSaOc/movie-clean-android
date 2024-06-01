package com.osao.moviecleanandroid.di

import com.osao.moviecleanandroid.domain.popular.repository.PopularRepository
import com.osao.moviecleanandroid.domain.popular.use_cases.PopularUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providePopularUseCase(
        popularRepository: PopularRepository
    ): PopularUseCase {
        return PopularUseCase(popularRepository)
    }
}