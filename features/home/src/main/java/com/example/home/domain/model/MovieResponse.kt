package com.example.home.domain.model


data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)