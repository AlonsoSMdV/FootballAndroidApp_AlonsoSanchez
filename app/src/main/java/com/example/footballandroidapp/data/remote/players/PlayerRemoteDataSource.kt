package com.example.footballandroidapp.data.remote.players

import com.example.footballandroidapp.data.models.players.Player
import com.example.footballandroidapp.data.remote.api.FootballApi
import retrofit2.Response
import javax.inject.Inject

class PlayerRemoteDataSource @Inject constructor(
    private val playerApi: FootballApi
): IPlayerRemoteDataSource {
    override suspend fun readAll(): Response<PlayerListRaw> {
        return playerApi.getPlayers()
    }

    override suspend fun readPlayersByTeam(filters: Map<String, String>): Response<PlayerListRaw> {
        return playerApi.getPlayersByTeam(filters)
    }

    override suspend fun readOne(id: Int): Response<Player> {
        return  playerApi.getOnePlayer(id)
    }

    override suspend fun createPlayer(player: PlayerCreate) {
        return playerApi.createPlayer(player)
    }

    override suspend fun deletePlayer(id: Int) {
        return playerApi.deletePlayer(id)
    }
}