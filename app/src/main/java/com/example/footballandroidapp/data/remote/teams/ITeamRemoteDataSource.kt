package com.example.footballandroidapp.data.remote.teams

import com.example.footballandroidapp.data.models.teams.Team
import retrofit2.Response

interface ITeamRemoteDataSource {
    suspend fun readAll(): Response<TeamListRaw>
    suspend fun readTeamsByLeague(filters: Map<String, String>): Response<TeamListRaw>
    suspend fun readOne(): Response<Team>
}