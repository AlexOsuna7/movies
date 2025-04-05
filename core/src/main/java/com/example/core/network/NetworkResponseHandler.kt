package com.example.core.network

sealed class NetworkResult<out T>{
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String) : NetworkResult<Nothing>()
}

suspend fun <T> safeApiCall(apiCall: suspend () -> T): NetworkResult<T> {
    return try {
        NetworkResult.Success(apiCall.invoke())
    } catch (e: Exception) {
        NetworkResult.Error(e.localizedMessage ?: "Unknown error")
    }
}