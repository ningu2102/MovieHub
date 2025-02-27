package com.nrkbytes.moviehub.data

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.nrkbytes.moviehub.data_models.Movie
import com.nrkbytes.moviehub.data_models.TvShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MediaViewModel @Inject constructor() : ViewModel() {

    fun getUpcomingMovies(): Flow<PagingData<Movie>> {
        return MediaRepository.getUpcomingMovies()
    }

    fun getPopularMovies(): Flow<PagingData<Movie>> {
        return MediaRepository.getPopularMoviesStream()
    }

    fun getPopularTvShows(): Flow<PagingData<TvShow>> {
        return MediaRepository.getPopularTvShowsStream()
    }
}