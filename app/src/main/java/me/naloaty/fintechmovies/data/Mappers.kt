package me.naloaty.fintechmovies.data

import me.naloaty.fintechmovies.data.api.MovieDetailsResponse
import me.naloaty.fintechmovies.data.api.MovieBriefResponse
import me.naloaty.fintechmovies.domain.models.MovieBrief
import me.naloaty.fintechmovies.domain.models.MovieDetails

fun MovieBriefResponse.toMovieBrief(): MovieBrief {
    return MovieBrief(
        id = this.filmId,
        title = this.nameRu ?: "", // TODO: Add locale settings
        year = this.year?.toInt() ?: -1,
        genres = this.genres.map { it.genre },
        countries = this.countries.map { it.country },
        posterUrl = this.posterUrl,
        posterPreviewUrl = this.posterUrlPreview
    )
}

fun MovieDetailsResponse.toMovieDetails(): MovieDetails {
    return MovieDetails(
        id = this.kinopoiskId,
        title = this.nameRu, // TODO: Add locale settings
        description = this.description,
        year = this.year,
        genres = this.genres.map { it.genre },
        countries = this.countries.map { it.country },
        posterUrl = this.posterUrl,
        posterPreviewUrl = this.posterUrlPreview
    )
}