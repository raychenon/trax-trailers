package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class Hero(
    @field:Json(name = "imageurl") val imageUrl: String
)