package com.example.footballandroidapp.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.footballandroidapp.data.local.entities.CompetitionE
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionDao {
    @Insert
    suspend fun create(comp: CompetitionE)

    @Insert
    suspend fun create(comps: List<CompetitionE>)

    @Delete
    suspend fun delete(comp: CompetitionE)

    @Upsert
    suspend fun update(comp: CompetitionE)

    @Query("SELECT * FROM competition WHERE id = :id")
    suspend fun readBy(id: String): CompetitionE

    @Query("SELECT * FROM competition")
    suspend fun readAll(): List<CompetitionE>

    @Query("SELECT * FROM competition")
    fun observeAll(): Flow<List<CompetitionE>>
}