package me.naloaty.fintechmovies.data.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.naloaty.fintechmovies.data.toMovieBrief
import me.naloaty.fintechmovies.domain.models.MovieBrief
import me.naloaty.fintechmovies.exceptions.NetworkLoadException
import retrofit2.HttpException
import javax.inject.Inject

class KinopoiskTopPagingSource @Inject constructor(
    private val kinopoiskService: KinopoiskService
): PagingSource<Int, MovieBrief>() {
    override fun getRefreshKey(state: PagingState<Int, MovieBrief>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null

        return page.prevKey?.plus(1)
            ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieBrief> {
        val page = params.key ?: INITIAL_PAGE_INDEX

        return try {
            val response = kinopoiskService.getTopMovies(page=page)

            if (response.isSuccessful) {
                val result = response.body()
                    ?: throw NetworkLoadException("API responded with unreliable data")

                val nextKey = if (page < result.pagesCount) page + 1 else null
                val prevKey = if (page > INITIAL_PAGE_INDEX) page - 1 else null

                LoadResult.Page(result.films.map { it.toMovieBrief() }, prevKey, nextKey)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val INITIAL_PAGE_INDEX = 1
    }

}