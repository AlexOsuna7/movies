package com.example.home.domain.usecase

import com.example.home.domain.model.Movie
import com.example.home.domain.model.MovieResponse
import com.example.home.domain.repository.MovieRepository

class GetPopularMoviesUseCase(
    private val repository: MovieRepository
) {

    suspend fun invoke(): MovieResponse {
        return repository.getPopularMovies()
    }


}