package com.nrkbytes.moviehub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.nrkbytes.moviehub.data_models.TvShow
import com.nrkbytes.moviehub.databinding.ItemMediaBinding

class PagedTvShowsAdapter(private val onItemClick: ((TvShow) -> Unit)) :
        PagingDataAdapter<TvShow, TvShowViewHolder>(TvShowDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        holder.bind(tvShow)
    }
}