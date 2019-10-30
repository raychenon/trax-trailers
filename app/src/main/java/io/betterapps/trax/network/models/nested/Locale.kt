package io.betterapps.trax.network.models.nested

import com.squareup.moshi.Json

data class Locale(
    @field:Json(name = "movie_title") val title: String,
    @field:Json(name = "synopsis") val synopsis: String
)