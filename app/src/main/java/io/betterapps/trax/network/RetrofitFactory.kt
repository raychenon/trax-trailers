package io.betterapps.trax.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    private val BASE_URL = "https://testepg.r0ro.fr"

    fun getMoviesServiceInstance(): MoviesService {
        val client = CustomCertClient()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client.create())
            .build()
        val service = retrofit.create(MoviesService::class.java)

        return service
    }

}