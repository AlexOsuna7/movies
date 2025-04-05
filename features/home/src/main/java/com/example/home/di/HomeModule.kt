package com.example.home.di

import com.example.home.data.remote.HomeApiService
import com.example.home.data.repository.MovieRepositoryImpl
import com.example.home.domain.repository.MovieRepository
import com.example.home.domain.usecase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): HomeApiService =
        retrofit.create(HomeApiService::class.java)

    @Provides
    @Singleton
    fun provideHomeRepository(
        homeApiService: HomeApiService
    ): MovieRepository = MovieRepositoryImpl(homeApiService)

    @Provides
    fun provideGetPopularMoviesUseCase(repository: MovieRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(repository)
    }
}