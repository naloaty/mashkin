package me.naloaty.fintechmovies.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.naloaty.fintechmovies.domain.repository.MoviesRepository
import me.naloaty.fintechmovies.domain.usecases.GetPopularMoviesUseCase
import me.naloaty.fintechmovies.presentation.popular.PopularMoviesViewModel
import javax.inject.Inject

class PopularMoviesViewModelFactory @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularMoviesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PopularMoviesViewModel(getPopularMoviesUseCase) as T
        } else {
            throw RuntimeException("Unknown view model class: $modelClass")
        }
    }
}