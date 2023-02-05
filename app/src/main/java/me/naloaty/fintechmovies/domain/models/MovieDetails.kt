package me.naloaty.fintechmovies.domain.models

data class MovieDetails(
    val id: Int,
    val title: String,
    val description: String,
    val year: Int,
    val genres: List<String>,
    val countries: List<String>,
    val posterUrl: String,
    val posterPreviewUrl: String
)