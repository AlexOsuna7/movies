package com.example.home.data.remote

import com.example.home.domain.model.MovieResponse
import retrofit2.http.GET

interface HomeApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieResponse
}