package io.betterapps.trax.network.models.nested

import com.squareup.moshi.Json

data class LocaleTop(
    @field:Json(name = "en") val en: Locale
)