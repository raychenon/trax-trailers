package io.betterapps.trax.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.betterapps.trax.network.RetrofitFactory

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val TAG = "MainViewModel"

    val service = RetrofitFactory.getMoviesServiceInstance()

    fun getMoviesResponse(): LiveData<String> = liveData {
        Log.d(TAG, "before call getMoviesResponse")

        try {
            val response = service.getMoviesResponse()
            val movieResponse = response.body()
            print("URL = ${response.raw().request}")
            if (response.isSuccessful) {
                Log.d(TAG, "isSuccessful ${movieResponse}")

                emit("Success ${movieResponse}")
            } else {
                Log.d(TAG, "Server failed ")
                emit("Failed ${response.raw().request}")
            }
        } catch (e: Throwable) {
            Log.d(TAG, "catch ${e.localizedMessage}")
            emit("Exception ${e.localizedMessage}")
        }
    }
}


