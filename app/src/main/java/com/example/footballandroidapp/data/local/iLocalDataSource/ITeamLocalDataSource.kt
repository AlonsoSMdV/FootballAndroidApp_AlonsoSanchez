package com.example.footballandroidapp.data.local.iLocalDataSource

import com.example.footballandroidapp.data.models.teams.Team
import kotlinx.coroutines.flow.Flow

interface ITeamLocalDataSource {
    suspend fun insert(competition: List<Team>)

    suspend fun readAll(): List<Team>

    suspend fun readTeamsByComp(compId: String): List<Team>

    fun observeAll(): Flow<List<Team>>
    fun observeByLeague(leagueId:Int): Flow<List<Team>>
}