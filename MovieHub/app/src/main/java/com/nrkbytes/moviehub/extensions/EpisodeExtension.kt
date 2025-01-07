package com.nrkbytes.moviehub.extensions

import com.nrkbytes.moviehub.constants.IMAGE_BASE_URL
import com.nrkbytes.moviehub.constants.ImageSize
import com.nrkbytes.moviehub.data_models.Episode

fun Episode.getStillUrl(size: ImageSize = ImageSize.ORIGINAL): String {
    return "$IMAGE_BASE_URL${size.value}${this.stillPath}"
}
