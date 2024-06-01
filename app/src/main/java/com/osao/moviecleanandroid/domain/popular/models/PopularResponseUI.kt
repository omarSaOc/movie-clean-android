package com.osao.moviecleanandroid.domain.popular.models

import com.google.gson.annotations.SerializedName

class PopularResponseUI (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<PopularMovieUI>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)