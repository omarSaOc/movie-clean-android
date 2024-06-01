package com.osao.moviecleanandroid.data.network

import com.osao.moviecleanandroid.data.network.models.response.PopularResponse
import com.osao.moviecleanandroid.data.network.models.response.TopRatedResponse
import com.osao.moviecleanandroid.data.network.models.response.UpcomingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "2a78f529dbe1372f6db020930a705fa4",
    ): PopularResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "2a78f529dbe1372f6db020930a705fa4",
    ): TopRatedResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "2a78f529dbe1372f6db020930a705fa4",
    ): UpcomingResponse
}