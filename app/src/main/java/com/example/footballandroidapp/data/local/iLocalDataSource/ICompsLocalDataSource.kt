package com.example.footballandroidapp.data.local.iLocalDataSource


import com.example.footballandroidapp.data.models.comps.Competition
import kotlinx.coroutines.flow.Flow

interface ICompsLocalDataSource {
    suspend fun insert(competition: List<Competition>)

    suspend fun readAll(): List<Competition>

    fun observeAll(): Flow<List<Competition>>
}