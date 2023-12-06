package com.example.androidlesson16.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidlesson16.data.repository.ApiRepository
import com.example.androidlesson16.presentation.model.MovieViewData

class MainViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    private val _movieLiveData = MutableLiveData<List<MovieViewData>>()
    val movieLiveData: LiveData<List<MovieViewData>>
        get() = _movieLiveData

    fun getTopRankedMovies() {
        apiRepository.getTopRatedMovies(_movieLiveData)
    }

}