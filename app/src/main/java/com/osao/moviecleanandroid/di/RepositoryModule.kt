package com.osao.moviecleanandroid.di

import com.osao.moviecleanandroid.data.network.MovieApi
import com.osao.moviecleanandroid.data.repository.PopularRepositoryImpl
import com.osao.moviecleanandroid.data.repository.TopRatedRepositoryImpl
import com.osao.moviecleanandroid.data.repository.UpcomingRepositoryImpl
import com.osao.moviecleanandroid.domain.popular.repository.PopularRepository
import com.osao.moviecleanandroid.domain.top_rated.repository.TopRatedRepository
import com.osao.moviecleanandroid.domain.upcoming.repository.UpcomingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun provideRPopularRepository(
        movieApi: MovieApi
    ): PopularRepository {
        return PopularRepositoryImpl(movieApi)
    }

    @Provides
    fun provideTopRatedRepository(
        movieApi: MovieApi
    ): TopRatedRepository {
        return TopRatedRepositoryImpl(movieApi)
    }

    @Provides
    fun provideUpcomingRepository(
        movieApi: MovieApi
    ): UpcomingRepository {
        return UpcomingRepositoryImpl(movieApi)
    }
}