package com.example.androidlesson16.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidlesson16.R
import com.example.androidlesson16.databinding.ListItemMovieBinding
import com.example.androidlesson16.presentation.model.MovieViewData
import com.example.androidlesson16.utils.IMAGE_URL

class MovieAdapter(
    private val movies: List<MovieViewData>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        movies.size

        return MovieViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    class MovieViewHolder(private val binding: ListItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieViewData) {
            with(binding) {
                titleTextView.text = movie.title
                subtitleTextView.text = movie.description
                ratingValueTextView.text = movie.rating.toString()

                Glide.with(binding.root.context)
                    .load(IMAGE_URL + movie.poster)
                    .placeholder(R.drawable.empty_image)
                    .into(posterImageView)
            }
        }
    }
}