package com.example.movies.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object AppModule {

    val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwZjY3YzZiMjQ5ZmU2YzVhNDk0OTcwNzk0MzcxZjVmMCIsIm5iZiI6MTc0MzYyOTMxMS4xNTI5OTk5LCJzdWIiOiI2N2VkYWJmZmE5ZDY3ZjUxZDBjOTI3YmIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.zth9Hq4_pouZTkSVQkwSvwBoQwRFo16zDYAhB54eOKw"
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String{
        return token
    }
}