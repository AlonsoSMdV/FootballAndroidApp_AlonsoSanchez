package com.example.footballandroidapp.data.models.comps

import com.example.footballandroidapp.data.remote.comps.CompCreate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ICompsRepository {
    val setStream: StateFlow<List<Competition>>
    suspend fun readAll(): List<Competition>
    suspend fun readOne(id: Int): Competition
    suspend fun createComp(comp: CompCreate)
    suspend fun deleteComp(id: Int)
    fun observeAll(): Flow<List<Competition>>
}