package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class Movie(
    @field:Json(name = "page") val page: Page,
    @field:Json(name = "clips") val clips: List<Clip>
) {

    fun title(): String? = page?.movie_title

    fun releaseDate(): String? = page?.release_date

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