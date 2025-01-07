package com.nrkbytes.moviehub.extensions

import com.nrkbytes.moviehub.data_models.Season
import com.nrkbytes.moviehub.network.models.TvDetailsResponse

fun TvDetailsResponse.getInitialSeasonIndex(): Int {
    if (this.seasons.isNotEmpty()) {
        var initialSeasonIndex = this.seasons.indexOfFirst { it.seasonNumber > 0 }
        if (initialSeasonIndex == -1) {
            initialSeasonIndex = 0
        }
        return initialSeasonIndex;
    }
    return -1
}