package io.betterapps.trax.network.models

import com.squareup.moshi.Json
import io.betterapps.trax.network.models.nested.Versions

data class Clip(
    @field:Json(name = "screen") val screen: String,
    @field:Json(name = "thumb") val thumb: String,
    @field:Json(name = "artist") val artist: String,
    @field:Json(name = "versions") val versions: Versions
)