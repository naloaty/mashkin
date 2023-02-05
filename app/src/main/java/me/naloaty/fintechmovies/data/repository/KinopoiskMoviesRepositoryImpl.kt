package me.naloaty.fintechmovies.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.naloaty.fintechmovies.data.api.KinopoiskSearchPagingSource
import me.naloaty.fintechmovies.data.api.KinopoiskService
import me.naloaty.fintechmovies.data.api.KinopoiskTopPagingSource
import me.naloaty.fintechmovies.data.toMovieDetails
import me.naloaty.fintechmovies.domain.repository.MoviesRepository
import me.naloaty.fintechmovies.domain.models.MovieBrief
import me.naloaty.fintechmovies.domain.models.MovieDetails
import me.naloaty.fintechmovies.exceptions.NetworkLoadException
import javax.inject.Inject

class KinopoiskMoviesRepositoryImpl @Inject constructor(
    private val kinopoiskService: KinopoiskService,
    private val kinopoiskTopPagingSource: KinopoiskTopPagingSource,
    private val kinopoiskSearchPagingSource: KinopoiskSearchPagingSource.Factory
): MoviesRepository {

    override fun getPopularMovies(): Flow<PagingData<MovieBrief>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true,
                prefetchDistance = PREFETCH_DISTANCE
            ),
            pagingSourceFactory = { kinopoiskTopPagingSource }
        ).flow
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        val response = kinopoiskService.getMovieDetails(movieId)

        if (response.isSuccessful) {
            val details = response.body()
                ?: throw NetworkLoadException("API responded with unreliable data")

            return details.toMovieDetails()
        } else {
            throw NetworkLoadException("API request failed")
        }
    }

    override fun searchMovies(keyword: String): Flow<PagingData<MovieBrief>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true,
                prefetchDistance = PREFETCH_DISTANCE
            ),
            pagingSourceFactory = {
                kinopoiskSearchPagingSource.create(keyword)
            }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 15
        const val PREFETCH_DISTANCE = 5
    }
}