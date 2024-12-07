package com.example.footballandroidapp.data.remote.players

import com.example.footballandroidapp.data.models.players.Player
import com.example.footballandroidapp.data.remote.teams.TeamListRaw
import retrofit2.Response

interface IPlayerRemoteDataSource {
    suspend fun readAll(): Response<PlayerListRaw>
    suspend fun readPlayersByTeam(filters: Map<String, String>): Response<PlayerListRaw>
    suspend fun readOne(id:Int): Response<Player>
    suspend fun createPlayer(player: PlayerCreate)
    suspend fun deletePlayer(id: Int)
}