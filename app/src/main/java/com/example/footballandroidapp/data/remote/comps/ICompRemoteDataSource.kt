package com.example.footballandroidapp.data.remote.comps

import com.example.footballandroidapp.data.models.comps.Competition
import retrofit2.Response

interface ICompRemoteDataSource {
    suspend fun readAll(): Response<CompListRaw>
    suspend fun readOne(id:Int): Response<Competition>
}