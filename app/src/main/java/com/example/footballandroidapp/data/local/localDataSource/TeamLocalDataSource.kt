package com.example.footballandroidapp.data.local.localDataSource

import com.example.footballandroidapp.data.local.database.TeamDao
import com.example.footballandroidapp.data.local.iLocalDataSource.ITeamLocalDataSource
import com.example.footballandroidapp.data.local.localModelMapping.toExternal
import com.example.footballandroidapp.data.local.localModelMapping.toLocal
import com.example.footballandroidapp.data.models.teams.Team
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamLocalDataSource @Inject constructor(
    private val tDao: TeamDao
): ITeamLocalDataSource {
    override suspend fun insert(tList: List<Team>) {
        tDao.create(tList.toLocal())
    }

    override suspend fun readAll(): List<Team> {
        return tDao.readAll().toExternal()
    }

    override suspend fun readTeamsByComp(compId: String): List<Team> {
        return tDao.readTeamsInComps(compId).toExternal()
    }

    override fun observeAll(): Flow<List<Team>> {
        return tDao.observeAll().map { localT -> localT.toExternal() }
    }

}