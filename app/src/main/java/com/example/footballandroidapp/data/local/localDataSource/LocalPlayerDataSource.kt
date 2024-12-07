package com.example.footballandroidapp.data.local.localDataSource

import com.example.footballandroidapp.data.local.database.PlayerDao
import com.example.footballandroidapp.data.local.iLocalDataSource.IPlayerLocalDataSource
import com.example.footballandroidapp.data.local.localModelMapping.toExternal
import com.example.footballandroidapp.data.local.localModelMapping.toLocal
import com.example.footballandroidapp.data.models.players.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlayerLocalDataSource @Inject constructor(
    private val playerDao: PlayerDao
): IPlayerLocalDataSource {
    override suspend fun insert(player: List<Player>) {
        playerDao.create(player.toLocal())
    }

    override suspend fun readAll(): List<Player> {
        return playerDao.readAll().toExternal()
    }

    override fun observeAll(): Flow<List<Player>> {
        return playerDao.observeAll().map { localPlayer -> localPlayer.toExternal() }
    }

}