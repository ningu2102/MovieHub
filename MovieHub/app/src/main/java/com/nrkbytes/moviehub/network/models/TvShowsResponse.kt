package com.nrkbytes.moviehub.network.models

import com.nrkbytes.moviehub.data_models.TvShow
import com.squareup.moshi.Json

data class TvShowsResponse(
        @Json(name = "page") val page: Int,
        @Json(name = "results") val results: List<TvShow>,
        @Json(name = "total_pages") val totalPages: Int,
        @Json(name = "total_results") val totalResults: Int
)