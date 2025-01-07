package com.nrkbytes.moviehub.data_models

data class Resource<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String? = null,
)
