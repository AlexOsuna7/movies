package com.example.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column {
        Text("HIIIII")

        when (uiState) {
            is HomeUiState.Loading -> {
                Text("Loading...")
            }

            is HomeUiState.Error -> {
                val errorMessage = (uiState as HomeUiState.Error).message
                Text("Failed: $errorMessage")
            }

            is HomeUiState.Success -> {
                val movies = (uiState as HomeUiState.Success).movies
                LazyColumn {
                    items(movies) { movie ->
                        Text(movie.title)
                    }
                }
            }
        }
    }
}