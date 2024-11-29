package com.example.footballandroidapp.data.remote.api

import com.example.footballandroidapp.data.local.entities.LoginRes
import com.example.footballandroidapp.data.local.entities.RegisterRes
import com.example.footballandroidapp.data.models.comps.Competition
import com.example.footballandroidapp.data.remote.comps.CompListRaw
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FootballApi   {
    @GET("leagues")
    suspend fun getCompetitions(): Response<CompListRaw>
    @GET("leagues/{id}")
    suspend fun getOneCompetition(@Path("id")id: Int): Response<Competition>

    @POST("auth/local")
    suspend fun login(@Body credentials: Map<String, String>): Response<LoginRes>

    @POST("auth/local/register")
    suspend fun register(@Body user: Map<String, String>): Response<RegisterRes>
}