package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class Movie(
    @field:Json(name = "page") val page: Page
)