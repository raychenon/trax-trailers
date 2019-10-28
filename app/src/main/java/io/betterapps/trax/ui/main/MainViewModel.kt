package io.betterapps.trax.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.betterapps.trax.network.RetrofitFactory
import io.betterapps.trax.network.models.MovieResponse

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val TAG = "MainViewModel"

    val service = RetrofitFactory.getMoviesServiceInstance()

    fun getMoviesResponse(): LiveData<MovieResponse> = liveData {
        Log.d(TAG, "before call getMoviesResponse")

        try {
            val response = service.getMoviesResponse()
            val movieResponse = response.body()
            print("URL = ${response.raw().request}")
            if (response.isSuccessful) {
                Log.d(TAG, "isSuccessful ${movieResponse}")

                emit(MovieResponse(false, movieResponse))
            } else {
                Log.d(TAG, "Server failed ")
                emit(MovieResponse(true, null))
            }
        } catch (e: Throwable) {
            Log.d(TAG, "catch ${e.localizedMessage}")
            emit(MovieResponse(true, null))
        }
    }
}


