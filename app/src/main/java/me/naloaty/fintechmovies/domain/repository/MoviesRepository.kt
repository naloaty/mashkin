package me.naloaty.fintechmovies.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.naloaty.fintechmovies.domain.models.MovieBrief
import me.naloaty.fintechmovies.domain.models.MovieDetails

interface MoviesRepository {

    fun getPopularMovies(): Flow<PagingData<MovieBrief>>

    suspend fun getMovieDetails(movieId: Int): MovieDetails

    fun searchMovies(keyword: String): Flow<PagingData<MovieBrief>>

}