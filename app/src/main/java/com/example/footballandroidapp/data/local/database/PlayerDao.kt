package com.example.footballandroidapp.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.footballandroidapp.data.local.entities.PlayerE
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Insert
    suspend fun create(comp: PlayerE)

    @Insert
    suspend fun create(comps: List<PlayerE>)

    @Delete
    suspend fun delete(comp: PlayerE)

    @Upsert
    suspend fun update(comp: PlayerE)

    @Query("SELECT * FROM player WHERE id = :id")
    suspend fun readBy(id: String): PlayerE

    @Query("SELECT * FROM player")
    suspend fun readAll(): List<PlayerE>

    @Query("SELECT * FROM player")
    fun observeAll(): Flow<List<PlayerE>>

    @Query("SELECT * FROM player p JOIN team t ON(p.teamId == t.id)")
    suspend fun readPlayersByTeam(teamId: String): List<PlayerE>

}