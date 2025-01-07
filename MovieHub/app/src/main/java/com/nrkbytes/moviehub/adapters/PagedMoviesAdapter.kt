package com.nrkbytes.moviehub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.nrkbytes.moviehub.data_models.Movie
import com.nrkbytes.moviehub.databinding.ItemMediaBinding

class PagedMoviesAdapter(private val onItemClick: ((Movie) -> Unit)) :
        PagingDataAdapter<Movie, MovieViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val media = getItem(position)
        holder.bind(media)
    }
}