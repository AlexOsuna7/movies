package com.example.home.data.mapper

import com.example.core.network.dto.MovieDto
import com.example.core.network.dto.MovieResponseDto
import com.example.home.domain.model.Movie
import com.example.home.domain.model.MovieResponse

fun MovieResponseDto.toDomain(): MovieResponse {
    return MovieResponse(
        page = page,
        results = results.map { it.toDomain() }
    )
}


fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        overview = overview,
        posterUrl = posterPath,
        title = title
    )
}
