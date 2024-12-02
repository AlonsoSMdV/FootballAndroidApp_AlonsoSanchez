package com.example.footballandroidapp.di

import com.example.footballandroidapp.data.local.iLocalDataSource.ITeamLocalDataSource
import com.example.footballandroidapp.data.local.localDataSource.TeamLocalDataSource
import com.example.footballandroidapp.data.models.teams.ITeamRepository
import com.example.footballandroidapp.data.models.teams.TeamRepository
import com.example.footballandroidapp.data.remote.teams.ITeamRemoteDataSource
import com.example.footballandroidapp.data.remote.teams.TeamRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TeamsModule {
    @Singleton
    @Binds
    abstract fun bindTeamsRepository(repository: TeamRepository): ITeamRepository

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSource: TeamLocalDataSource): ITeamLocalDataSource

    @Singleton
    @Binds
    abstract fun bindTeamRemote(remote: TeamRemoteDataSource): ITeamRemoteDataSource
}