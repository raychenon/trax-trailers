package io.betterapps.trax.network.models.nested

import com.squareup.moshi.Json

data class Details(
    @field:Json(name = "locale") val locale: LocaleTop
)