package com.example.footballandroidapp.data.local.iLocalDataSource

import com.example.footballandroidapp.data.models.players.Player
import kotlinx.coroutines.flow.Flow

interface IPlayerLocalDataSource {
    suspend fun insert(player: List<Player>)

    suspend fun readAll(): List<Player>

    fun observeAll(): Flow<List<Player>>
}