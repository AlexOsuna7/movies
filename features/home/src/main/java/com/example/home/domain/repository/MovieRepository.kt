package com.example.home.domain.repository

import com.example.home.domain.model.MovieResponse

interface MovieRepository {
    suspend fun getPopularMovies(): MovieResponse

}