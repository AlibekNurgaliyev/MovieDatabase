package com.example.androidlesson16.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: String?,
    @SerializedName("results") val results: List<Movie>?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("total_results") val totalResults: Int?
)

data class Movie(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("overview") val description: String?,
    @SerializedName("vote_average") val rating: Double?,
    @SerializedName("adult") val isAdult: Boolean?,
    @SerializedName("poster_path") val poster: String?
)