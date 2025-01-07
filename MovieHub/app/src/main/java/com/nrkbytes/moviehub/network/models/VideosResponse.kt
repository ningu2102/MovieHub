package com.nrkbytes.moviehub.network.models

import com.nrkbytes.moviehub.data_models.Video

data class VideosResponse(
        val results: List<Video>,
)