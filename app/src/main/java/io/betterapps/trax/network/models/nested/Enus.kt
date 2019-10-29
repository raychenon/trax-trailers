package io.betterapps.trax.network.models.nested

import com.squareup.moshi.Json
import io.betterapps.trax.network.models.nested.Sizes

data class Enus(
    @field:Json(name = "sizes") val sizes: Sizes
)