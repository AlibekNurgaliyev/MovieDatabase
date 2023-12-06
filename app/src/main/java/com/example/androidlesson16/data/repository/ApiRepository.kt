package com.example.androidlesson16.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.androidlesson16.data.api.MovieApiInterface
import com.example.androidlesson16.data.model.MovieResponse
import com.example.androidlesson16.presentation.model.MovieViewData
import com.example.androidlesson16.presentation.model.fromResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "ApiRepository"

class ApiRepository(private val movieApiInterface: MovieApiInterface) {

    fun getTopRatedMovies(movieLiveData: MutableLiveData<List<MovieViewData>>) {
        val call = movieApiInterface.getTopRatedMovies(language = "ru")

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val result = response.body()!!.results!!.fromResponse()

                result.forEach {
                    Log.d(TAG, "title ${it.title}")
                }

                movieLiveData.value = result
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d(TAG, "$t")
            }
        })
    }
}