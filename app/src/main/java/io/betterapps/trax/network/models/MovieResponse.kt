package io.betterapps.trax.network.models

data class MovieResponse(
    val hasError: Boolean,
    val movies: List<Movie>?
)