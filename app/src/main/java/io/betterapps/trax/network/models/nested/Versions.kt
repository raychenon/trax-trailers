package io.betterapps.trax.network.models.nested

import com.squareup.moshi.Json

data class Versions(
    @field:Json(name = "enus") val enus: Enus
)