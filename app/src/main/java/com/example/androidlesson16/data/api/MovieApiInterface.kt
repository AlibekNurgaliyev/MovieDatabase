package com.example.androidlesson16.data.api

import com.example.androidlesson16.BuildConfig
import com.example.androidlesson16.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page:Int = 2,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<MovieResponse>
}