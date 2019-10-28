package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class Heros(
    @field:Json(name = "heros") val heros: List<Hero>
)