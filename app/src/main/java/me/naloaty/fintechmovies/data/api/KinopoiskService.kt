package me.naloaty.fintechmovies.data.api


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response

interface KinopoiskService {

    @GET("/api/v2.2/films/top")
    suspend fun getTopMovies(
        @Query("type") type: String = "TOP_100_POPULAR_FILMS",
        @Query("page") page: Int
    ): Response<MovieListResponse>

    @GET("/api/v2.2/films/{id}")
    suspend fun getMovieDetails(
        @Path("id") movieId: Int
    ): Response<MovieDetailsResponse>

    @GET("/api/v2.1/search-by-keyword")
    suspend fun searchMoviesByKeyword(
        @Query("keyword") keyword: String
    ): Response<MovieListResponse>
}