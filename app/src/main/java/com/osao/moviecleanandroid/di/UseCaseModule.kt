package com.osao.moviecleanandroid.di

import com.osao.moviecleanandroid.domain.popular.repository.PopularRepository
import com.osao.moviecleanandroid.domain.popular.use_cases.PopularUseCase
import com.osao.moviecleanandroid.domain.top_rated.repository.TopRatedRepository
import com.osao.moviecleanandroid.domain.top_rated.use_cases.TopRatedUseCase
import com.osao.moviecleanandroid.domain.upcoming.repository.UpcomingRepository
import com.osao.moviecleanandroid.domain.upcoming.use_cases.UpcomingUseCase
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

    @Provides
    fun provideTopRatedUseCase(
        topRatedRepository: TopRatedRepository
    ): TopRatedUseCase {
        return TopRatedUseCase(topRatedRepository)
    }

    @Provides
    fun provideUpcomingUseCase(
        upcomingRepository: UpcomingRepository
    ): UpcomingUseCase {
        return UpcomingUseCase(upcomingRepository)
    }

}