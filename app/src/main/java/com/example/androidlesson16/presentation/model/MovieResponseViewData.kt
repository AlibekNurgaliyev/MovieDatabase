package com.example.androidlesson16.presentation.model

import com.example.androidlesson16.data.model.Movie
import com.example.androidlesson16.data.model.MovieResponse

data class MovieResponseViewData(
    val page: String = "",
    val results: List<MovieViewData>,
    val totalPages: Int = 0,
    val totalResults: Int = 0
)

data class MovieViewData(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val rating: Double = 0.0,
    val isAdult: Boolean = false,
    val poster: String = ""
)

fun MovieResponse.fromResponse(): MovieResponseViewData {
    return MovieResponseViewData(
        page = page.orEmpty(),
        results = results?.fromResponse() ?: emptyList(),
        totalPages = totalPages ?: 0,
        totalResults = totalResults ?: 0
    )
}

fun List<Movie>.fromResponse(): List<MovieViewData> {
    return map {
        MovieViewData(
            id = it.id ?: 0,
            title = it.title.orEmpty(),
            description = it.description.orEmpty(),
            rating = it.rating ?: 0.0,
            isAdult = it.isAdult ?: false,
            poster = it.poster.orEmpty()
        )
    }
}