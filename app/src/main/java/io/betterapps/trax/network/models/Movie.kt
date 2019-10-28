package io.betterapps.trax.network.models

import com.squareup.moshi.Json

data class Movie(
    @field:Json(name = "page") val page: Page,
    @field:Json(name = "clips") val clips: List<Clip>
){
    fun thumbnail(): String{
        return clips[0].thumb
    }
}