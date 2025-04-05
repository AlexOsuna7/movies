package com.example.home.presentation

import com.example.home.domain.model.Movie
import com.example.home.domain.model.MovieResponse

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data class Success(val page: Int, val movies: List<Movie>): HomeUiState()
    data class Error(val message: String): HomeUiState()
}