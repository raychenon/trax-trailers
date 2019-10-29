package io.betterapps.trax.network.models.nested

import com.squareup.moshi.Json
import io.betterapps.trax.network.models.ClipSize

data class Sizes(
    @field:Json(name = "sd") val sd: ClipSize,
    @field:Json(name = "hd720") val hd720: ClipSize,
    @field:Json(name = "hd1080") val hd1080: ClipSize
)