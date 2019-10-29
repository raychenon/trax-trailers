package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class ClipSize(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "src") val src: String,
    @field:Json(name = "srcAlt") val srcAlt: String,
    @field:Json(name = "filename") val filename: String,
    @field:Json(name = "height") val height: Int,
    @field:Json(name = "width") val width: Int
)