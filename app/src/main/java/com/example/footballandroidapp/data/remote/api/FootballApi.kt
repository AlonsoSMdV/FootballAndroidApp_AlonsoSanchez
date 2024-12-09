package com.example.footballandroidapp.data.remote.api

import com.example.footballandroidapp.data.local.entities.LoginRes
import com.example.footballandroidapp.data.local.entities.RegisterRes
import com.example.footballandroidapp.data.models.comps.Competition
import com.example.footballandroidapp.data.models.players.Player
import com.example.footballandroidapp.data.models.teams.Team
import com.example.footballandroidapp.data.remote.comps.CompCreate
import com.example.footballandroidapp.data.remote.comps.CompListRaw
import com.example.footballandroidapp.data.remote.players.PlayerCreate
import com.example.footballandroidapp.data.remote.players.PlayerListRaw
import com.example.footballandroidapp.data.remote.teams.TeamCreate
import com.example.footballandroidapp.data.remote.teams.TeamListRaw
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface FootballApi   {
    @GET("leagues")
    suspend fun getCompetitions(): Response<CompListRaw>
    @GET("leagues/{id}")
    suspend fun getOneCompetition(@Path("id")id: Int): Response<Competition>
    @POST("leagues")
    suspend fun createComp(@Body comp: CompCreate)
    @DELETE("leagues/{id}")
    suspend fun deleteComp(@Path("id")id: Int)

    @GET("teams")
    suspend fun getTeams(): Response<TeamListRaw>
    @GET("teams/{id}")
    suspend fun getOneTeam(id : Int): Response<Team>
    @GET("teams")
    suspend fun getTeamsByLeague(@QueryMap filters: Map<String, String>): Response<TeamListRaw>
    @POST("teams")
    suspend fun createTeam(@Body team: TeamCreate)
    @DELETE("teams/{id}")
    suspend fun deleteTeam(@Path("id")id: Int)

    @GET("players")
    suspend fun getPlayers(): Response<PlayerListRaw>
    @GET("players/{id}")
    suspend fun getOnePlayer(@Path("id")id : Int): Response<Player>
    @GET("players")
    suspend fun getPlayersByTeam(@QueryMap filters: Map<String, String>): Response<PlayerListRaw>
    @POST("players")
    suspend fun createPlayer(@Body player: PlayerCreate)
    @DELETE("players/{id}")
    suspend fun deletePlayer(@Path("id")id: Int)

    @POST("auth/local")
    suspend fun login(@Body credentials: Map<String, String>): Response<LoginRes>

    @POST("auth/local/register")
    suspend fun register(@Body user: Map<String, String>): Response<RegisterRes>
}