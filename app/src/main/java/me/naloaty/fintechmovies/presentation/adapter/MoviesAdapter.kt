package me.naloaty.fintechmovies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import me.naloaty.fintechmovies.databinding.LayoutMovieItemBinding
import me.naloaty.fintechmovies.domain.models.MovieBrief
import javax.inject.Inject

class MoviesAdapter @Inject constructor():
    PagingDataAdapter<MovieBrief, MoviesViewHolder>(diffCallback) {

    var onMovieItemClickListener: ((MovieBrief) -> Unit)? = null

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindTo(item)

        item?.let {
            holder.binding.root.setOnClickListener {
                onMovieItemClickListener?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutMovieItemBinding.inflate(inflater, parent, false)

        return MoviesViewHolder(binding)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<MovieBrief>() {
            override fun areItemsTheSame(oldItem: MovieBrief, newItem: MovieBrief): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieBrief, newItem: MovieBrief): Boolean {
                return oldItem == newItem
            }
        }
    }
}