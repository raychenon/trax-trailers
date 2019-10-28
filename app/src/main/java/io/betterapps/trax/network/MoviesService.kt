package io.betterapps.trax.network

import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("/movies.json")
    suspend fun getMoviesResponse(): Response<String>
}