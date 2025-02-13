package com.example.footballandroidapp.data.remote.teams

import com.example.footballandroidapp.data.models.teams.Team
import com.example.footballandroidapp.data.remote.api.FootballApi
import com.example.footballandroidapp.data.remote.comps.CompCreate
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

    override suspend fun readOne(id: Int): Response<Team> {
        return teamApi.getOneTeam(id)
    }

    override suspend fun createTeam(team: TeamCreate) {
        return teamApi.createTeam(team)
    }

    override suspend fun deleteTeam(id: Int) {
        return teamApi.deleteTeam(id)
    }


}