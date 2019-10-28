package io.betterapps.trax.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("trax/movies.json")
    suspend fun getMoviesResponse(): Response<String>

}