package com.osao.moviecleanandroid.data.network.models.response

import com.google.gson.annotations.SerializedName

class PopularResponse (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<PopularMovie>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)