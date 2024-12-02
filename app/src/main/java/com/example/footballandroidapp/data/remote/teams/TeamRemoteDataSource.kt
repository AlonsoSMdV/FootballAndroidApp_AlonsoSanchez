package com.example.footballandroidapp.data.remote.teams

import com.example.footballandroidapp.data.models.teams.Team
import com.example.footballandroidapp.data.remote.api.FootballApi
import retrofit2.Response
import javax.inject.Inject

class TeamRemoteDataSource @Inject constructor(
    private val teamApi: FootballApi
): ITeamRemoteDataSource {
    override suspend fun readAll(): Response<TeamListRaw> {
        return teamApi.getTeams()
    }

    override suspend fun readTeamsByLeague(filters: Map<String, String>): Response<TeamListRaw> {
        return teamApi.getTeamsByLeague(filters)
    }

    override suspend fun readOne(): Response<Team> {
        return teamApi.getOneTeam()
    }
}