package me.naloaty.fintechmovies.domain.usecases


import me.naloaty.fintechmovies.domain.models.MovieDetails
import me.naloaty.fintechmovies.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MoviesRepository
){
    suspend operator fun invoke(movieId: Int): MovieDetails {
        return repository.getMovieDetails(movieId)
    }
}