package com.example.androidlesson16.di

import com.example.androidlesson16.data.repository.ApiRepository
import com.example.androidlesson16.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var moviesModule = module {
    factory { ApiRepository(
        movieApiInterface = get()
    ) }
    viewModel {
        MainViewModel(
            apiRepository = get()
        )
    }
}