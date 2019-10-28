package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class Page(
    @field:Json(name = "movie_title") val movie_title: String,
    @field:Json(name = "release_date") val release_date: String
)