package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class Clip(
    @field:Json(name = "screen") val screen: String,
    @field:Json(name = "thumb") val thumb: String,
    @field:Json(name = "artist") val artist: String
)