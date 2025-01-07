package com.nrkbytes.moviehub.screens

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.nrkbytes.moviehub.adapters.PagedMoviesAdapter
import com.nrkbytes.moviehub.data.MediaViewModel
import com.nrkbytes.moviehub.data_models.Movie
import com.nrkbytes.moviehub.databinding.ActivityPopularMoviesBinding
import com.nrkbytes.moviehub.extensions.toMediaBsData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class PopularMoviesActivity : BaseActivity() {
    private lateinit var binding: ActivityPopularMoviesBinding
    private val viewModel by viewModels<MediaViewModel>()
    private lateinit var popularMoviesItemsAdapter: PagedMoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        fetchData()
    }

    private fun setupUI() {
        binding.toolbar.setNavigationOnClickListener { finish() }
        popularMoviesItemsAdapter = PagedMoviesAdapter(this::handleMovieClick)
        binding.popularMoviesList.adapter = popularMoviesItemsAdapter
    }

    private fun fetchData() {
        lifecycleScope.launchWhenCreated {
            try {
                viewModel.getPopularMovies().collectLatest {
                    popularMoviesItemsAdapter.submitData(it)
                }
            } catch (e: Exception) {
            }
        }
    }

    fun handleMovieClick(movie: Movie) {
        MediaDetailsBottomSheet.newInstance(movie.toMediaBsData())
            .show(supportFragmentManager, movie.id.toString())
    }
}