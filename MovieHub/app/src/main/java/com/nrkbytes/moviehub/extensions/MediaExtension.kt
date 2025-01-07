package com.nrkbytes.moviehub.extensions

import com.nrkbytes.moviehub.data_models.Media

fun Media.getId(): Int {
    return when (this) {
        is Media.Movie -> id
        is Media.Tv -> id
        else -> -1
    }
}