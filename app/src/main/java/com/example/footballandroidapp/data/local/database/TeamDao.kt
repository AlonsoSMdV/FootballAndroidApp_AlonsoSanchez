package com.example.footballandroidapp.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.footballandroidapp.data.local.entities.TeamE
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Insert
    suspend fun create(comp: TeamE)

    @Insert
    suspend fun create(comps: List<TeamE>)

    @Delete
    suspend fun delete(comp: TeamE)

    @Upsert
    suspend fun update(comp: TeamE)

    @Query("SELECT * FROM team WHERE id = :id")
    suspend fun readBy(id: String): TeamE

    @Query("SELECT * FROM team")
    suspend fun readAll(): List<TeamE>

    @Query("SELECT * FROM team")
    fun observeAll(): Flow<List<TeamE>>

    @Query("SELECT * FROM team t JOIN competition c ON(:compId == c.id)")
    suspend fun readTeamsInComps(compId: String): List<TeamE>
}