package me.naloaty.fintechmovies.domain.models

data class MovieBrief(
    val id: Int,
    val title: String,
    val year: Int,
    val genres: List<String>,
    val countries: List<String>,
    val posterUrl: String,
    val posterPreviewUrl: String
)