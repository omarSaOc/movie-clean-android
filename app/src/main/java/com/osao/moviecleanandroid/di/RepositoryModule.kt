package com.osao.moviecleanandroid.di

import com.osao.moviecleanandroid.data.network.MovieApi
import com.osao.moviecleanandroid.data.repository.PopularRepositoryImpl
import com.osao.moviecleanandroid.domain.popular.repository.PopularRepository
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
}