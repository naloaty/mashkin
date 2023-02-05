package me.naloaty.fintechmovies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import me.naloaty.fintechmovies.databinding.LayoutMovieItemPlaceholderBinding
import javax.inject.Inject

class MoviesLoadStateAdapter @Inject constructor():
    LoadStateAdapter<MoviesLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: MoviesLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): MoviesLoadStateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutMovieItemPlaceholderBinding.inflate(inflater, parent, false)

        return MoviesLoadStateViewHolder(binding)
    }
}