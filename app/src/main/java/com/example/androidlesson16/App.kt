package com.example.androidlesson16

import android.app.Application
import com.example.androidlesson16.di.apiModule
import com.example.androidlesson16.di.moviesModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(apiModule, moviesModule)
        }
    }
}