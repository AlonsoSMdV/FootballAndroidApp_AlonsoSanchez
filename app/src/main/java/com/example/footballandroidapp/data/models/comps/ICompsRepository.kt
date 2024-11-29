package com.example.footballandroidapp.data.models.comps

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ICompsRepository {
    val setStream: StateFlow<List<Competition>>
    suspend fun readAll(): List<Competition>
    suspend fun readOne(id: Int): Competition
    fun observeAll(): Flow<List<Competition>>
}