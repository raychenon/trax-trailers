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
            val response = service.getMoviessResponse()
            if (response.isSuccessful) {
                Log.d(TAG, "isSuccessful ${response?.body()}")

//                emit(albumLiveState)
            } else {
                Log.d(TAG, "Server failed ")

            }
        } catch (e: Throwable) {
            Log.d(TAG, "catch ${e.localizedMessage}")
//            emit(albumLiveState)
        }
    }
}


