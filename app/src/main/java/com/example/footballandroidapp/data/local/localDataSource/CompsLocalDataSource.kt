package com.example.footballandroidapp.data.local.localDataSource


import com.example.footballandroidapp.data.local.database.CompetitionDao
import com.example.footballandroidapp.data.local.iLocalDataSource.ICompsLocalDataSource
import com.example.footballandroidapp.data.local.localModelMapping.toExternal
import com.example.footballandroidapp.data.local.localModelMapping.toLocal
import com.example.footballandroidapp.data.models.comps.Competition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CompsLocalDataSource @Inject constructor(
    private val compDao: CompetitionDao
): ICompsLocalDataSource {
    override suspend fun insert(competition: List<Competition>) {
        compDao.create(competition.toLocal())
    }

    override suspend fun readAll(): List<Competition> {
        return compDao.readAll().toExternal()
    }

    override fun observeAll(): Flow<List<Competition>> {
        return compDao.observeAll().map { localComp -> localComp.toExternal() }
    }
}