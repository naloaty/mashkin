package me.naloaty.fintechmovies.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.naloaty.fintechmovies.R
import me.naloaty.fintechmovies.databinding.LayoutMovieListItemBinding
import me.naloaty.fintechmovies.domain.models.MovieBrief

class MoviesViewHolder(
    private val binding: LayoutMovieListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    private val resources = binding.root.resources

    // Items might be null if they are not paged in yet
    fun bindTo(movie: MovieBrief?) {
        if (movie == null) return

        binding.tvTitle.text = movie.title
        binding.tvDescription.text = resources.getString(
            R.string.brief_movie_description, movie.genres[0], movie.year)

        Glide.with(binding.root)
            .load(movie.posterPreviewUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.ivPoster)
    }
}