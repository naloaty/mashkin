package me.naloaty.fintechmovies.presentation.popular

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.naloaty.fintechmovies.domain.models.MovieBrief
import me.naloaty.fintechmovies.domain.usecases.GetPopularMoviesUseCase
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    val popularMovies: Flow<PagingData<MovieBrief>>
        get() = getPopularMoviesUseCase()
}