package com.example.footballandroidapp.di

import com.example.footballandroidapp.data.remote.api.FootballApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://footballcompsstrapi.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideStrapiService(retrofit: Retrofit): FootballApi {
        return retrofit.create(FootballApi::class.java)
    }
}