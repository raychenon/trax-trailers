package io.betterapps.trax.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitFactory {

    private val BASE_URL = "https://acloudgurualexa20190925.s3.eu-west-2.amazonaws.com/trax/"

    fun getMoviesServiceInstance(): MoviesService {
//        val client = CustomCertClient()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
//            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
//            .client(client.create())
            .build()
        val service = retrofit.create(MoviesService::class.java)

        return service
    }

}