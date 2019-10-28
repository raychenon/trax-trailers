package io.betterapps.trax.network.models

import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import android.provider.MediaStore.Video
import com.squareup.moshi.FromJson






class MovieAdapter {

//    @ToJson
//    fun toJson(movieResponse: MovieResponse): String {
//
//        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//        val type = Types.newParameterizedType(List<*>::class.java, Movie::class.java)
//        val adapter = moshi.adapter(type)
//        val movies = adapter.fromJson(movieResponse)
//
//    }
//
//    @FromJson
//    fun fromJson(json: MovieResponse): List<Video> {
//        return json.results
//    }

}