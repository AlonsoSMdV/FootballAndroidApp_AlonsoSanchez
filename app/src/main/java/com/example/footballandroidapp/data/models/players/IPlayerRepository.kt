package com.example.footballandroidapp.data.models.players

import com.example.footballandroidapp.data.models.teams.Team
import com.example.footballandroidapp.data.remote.players.PlayerCreate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface IPlayerRepository {
    val setStream: StateFlow<List<Player>>
    suspend fun readAll(): List<Player>
    suspend fun readPlayersByTeam(teamId: Int): List<Player>
    suspend fun readOne(id: Int): Player
    suspend fun createPlayer(player: PlayerCreate)
    suspend fun deletePlayer(id: Int)
    fun observeAll(): Flow<List<Player>>
}