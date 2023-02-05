package me.naloaty.fintechmovies.presentation.adapter

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import me.naloaty.fintechmovies.databinding.LayoutMovieListItemBinding

class MoviesLoadStateViewHolder(
    private val binding: LayoutMovieListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState: LoadState) = with(binding) {
        when(loadState) {
            is LoadState.NotLoading -> {
                if (shimmerContainer.isShimmerStarted)
                    shimmerContainer.stopShimmer()

                if (shimmerContainer.isShimmerVisible)
                    shimmerContainer.hideShimmer()
            }
            is LoadState.Loading -> {
                shimmerContainer.isVisible = true
                shimmerContainer.startShimmer()
            }
            is LoadState.Error   -> { /* Do nothing */ }
            else -> { /* Do nothing */ }
        }
    }
}