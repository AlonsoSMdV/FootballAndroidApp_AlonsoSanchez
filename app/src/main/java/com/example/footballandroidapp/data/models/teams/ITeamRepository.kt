package com.example.footballandroidapp.data.models.teams

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ITeamRepository {
    val setStream: StateFlow<List<Team>>
    suspend fun readAll(): List<Team>
    suspend fun readTeamsByLeague(leagueId: Int): List<Team>
    suspend fun readOne(id: Int): Team
    fun observeAll(): Flow<List<Team>>
    fun observeTeamsByLeague(leagueId:Int): Flow<List<Team>>
}