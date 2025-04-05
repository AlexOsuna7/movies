package com.example.core.network

import com.example.core.network.dto.MovieResponseDto
import retrofit2.http.GET

//Probably should be delete in the future
interface ApiService {

    @GET("/movie/popular")
    suspend fun getCountries(): List<MovieResponseDto>
}