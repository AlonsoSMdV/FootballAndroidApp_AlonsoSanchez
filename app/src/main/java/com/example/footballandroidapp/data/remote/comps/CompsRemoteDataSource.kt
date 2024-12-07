package com.example.footballandroidapp.data.remote.comps

import com.example.footballandroidapp.data.models.comps.Competition
import com.example.footballandroidapp.data.remote.api.FootballApi
import retrofit2.Response
import javax.inject.Inject

class CompsRemoteDataSource @Inject constructor(
    private val compApi: FootballApi
): ICompRemoteDataSource {
    override suspend fun readAll(): Response<CompListRaw> {
        return compApi.getCompetitions()
    }

    override suspend fun readOne(id: Int): Response<Competition> {
        return compApi.getOneCompetition(id)
    }

    override suspend fun createComp(comp: CompCreate) {
        return compApi.createComp(comp)
    }

    override suspend fun deleteComp(id: Int) {
        return compApi.deleteComp(id)
    }
}