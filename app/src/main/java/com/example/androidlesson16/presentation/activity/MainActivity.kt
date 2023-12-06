package com.example.androidlesson16.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlesson16.databinding.ActivityMainBinding
import com.example.androidlesson16.presentation.adapter.MovieAdapter
import com.example.androidlesson16.presentation.model.MovieViewData
import com.example.androidlesson16.presentation.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getTopRankedMovies()

        viewModel.movieLiveData.observe(this, ::handleMovies)
    }

    private fun handleMovies(movies: List<MovieViewData>) {
        binding.movieRecyclerView.adapter = MovieAdapter(movies)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}