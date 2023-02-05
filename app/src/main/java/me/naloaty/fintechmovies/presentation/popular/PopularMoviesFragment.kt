package me.naloaty.fintechmovies.presentation.popular

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import me.naloaty.fintechmovies.R
import me.naloaty.fintechmovies.databinding.FragmentPopularMoviesBinding
import me.naloaty.fintechmovies.di.viewmodel.PopularMoviesViewModelFactory
import me.naloaty.fintechmovies.presentation.*
import me.naloaty.fintechmovies.presentation.adapter.MoviesAdapter
import me.naloaty.fintechmovies.presentation.adapter.MoviesLoadStateAdapter
import me.naloaty.fintechmovies.presentation.adapter.withLoadStateAdapters
import javax.inject.Inject


class PopularMoviesFragment : BaseFragment(R.layout.fragment_popular_movies) {

    @Inject lateinit var viewModelFactory: PopularMoviesViewModelFactory

    private val binding by viewBinding(FragmentPopularMoviesBinding::bind)
    private val viewModel: PopularMoviesViewModel by viewModels { viewModelFactory }

    @Inject lateinit var moviesAdapter: MoviesAdapter
    @Inject lateinit var initialMoviesLoadStateAdapter: MoviesLoadStateAdapter
    @Inject lateinit var moviesLoadStateAdapter: MoviesLoadStateAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presentationComponent.inject(this)
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() = with(binding) {
        rvMovies.layoutManager = LinearLayoutManager(context)
        rvMovies.adapter = moviesAdapter.withLoadStateAdapters(
            header = initialMoviesLoadStateAdapter,
            footer = moviesLoadStateAdapter
        )
    }

    private fun observeViewModel() = with(viewLifecycleOwner.lifecycleScope) {
        launchWhenStarted {
            viewModel.popularMovies.collectLatest(moviesAdapter::submitData)
        }
    }

}