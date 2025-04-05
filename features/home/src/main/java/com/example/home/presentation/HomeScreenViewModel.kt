package com.example.home.presentation

import androidx.lifecycle.ViewModel
import com.example.home.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private fun getMoviesFlow(): Flow<HomeUiState> = flow {
        emit(HomeUiState.Loading)
        try {
            val movies = getPopularMoviesUseCase.invoke()
            emit(HomeUiState.Success(movies.page, movies.results))
        } catch (exception: Exception){
            emit(HomeUiState.Error(exception.message ?: "UNKNOWN ERROR"))
        }
    }.flowOn(Dispatchers.IO)

}