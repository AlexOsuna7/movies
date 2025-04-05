package com.example.home.data.repository

import com.example.home.data.remote.HomeApiService
import com.example.home.domain.model.Movie
import com.example.home.domain.model.MovieResponse
import com.example.home.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: HomeApiService
) :MovieRepository {
    override suspend fun getPopularMovies(): MovieResponse {
        return api.getPopularMovies()
    }
}