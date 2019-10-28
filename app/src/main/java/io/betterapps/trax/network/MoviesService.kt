package io.betterapps.trax.network

import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("/movies")
    suspend fun getMoviessResponse(): Response<String>
}