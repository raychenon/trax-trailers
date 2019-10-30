package io.betterapps.trax.network.models

import com.squareup.moshi.Json
import io.betterapps.trax.network.models.nested.Details

data class Movie(
    @field:Json(name = "page") val page: Page,
    @field:Json(name = "clips") val clips: List<Clip>,
    @field:Json(name = "details") val details: Details
) {

    fun title(): String? = page?.movie_title

    fun releaseDate(): String? = page?.release_date

    fun sypnosis(): String? = details?.locale?.en?.synopsis

    fun thumbnail(): String {
        return selectClip().thumb
    }

    fun m4v(): String {
        return selectClip().versions.enus.sizes.sd.srcAlt
    }

    fun mov(): String {
        return selectClip().versions.enus.sizes.sd.src
    }

    private fun selectClip(): Clip {
        return clips[0]
    }
}