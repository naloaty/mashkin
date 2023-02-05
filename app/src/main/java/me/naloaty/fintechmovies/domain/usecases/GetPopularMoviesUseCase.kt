package me.naloaty.fintechmovies.domain.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.naloaty.fintechmovies.domain.models.MovieBrief
import me.naloaty.fintechmovies.domain.repository.MoviesRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
){
    operator fun invoke(): Flow<PagingData<MovieBrief>> {
        return repository.getPopularMovies()
    }
}