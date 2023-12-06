package com.example.androidlesson16.di

import com.example.androidlesson16.data.api.MovieApiInterface
import com.example.androidlesson16.utils.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var apiModule = module {
    single { provideRetrofit() }
}

fun provideRetrofit(): MovieApiInterface {

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(MovieApiInterface::class.java)
}