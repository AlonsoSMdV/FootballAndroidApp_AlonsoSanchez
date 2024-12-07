package com.example.footballandroidapp.di

import com.example.footballandroidapp.data.local.iLocalDataSource.ICompsLocalDataSource
import com.example.footballandroidapp.data.local.iLocalDataSource.IPlayerLocalDataSource
import com.example.footballandroidapp.data.local.localDataSource.CompsLocalDataSource
import com.example.footballandroidapp.data.local.localDataSource.PlayerLocalDataSource
import com.example.footballandroidapp.data.models.comps.CompsRepository
import com.example.footballandroidapp.data.models.comps.ICompsRepository
import com.example.footballandroidapp.data.models.players.IPlayerRepository
import com.example.footballandroidapp.data.models.players.PlayerRepository
import com.example.footballandroidapp.data.remote.comps.CompsRemoteDataSource
import com.example.footballandroidapp.data.remote.comps.ICompRemoteDataSource
import com.example.footballandroidapp.data.remote.players.IPlayerRemoteDataSource
import com.example.footballandroidapp.data.remote.players.PlayerRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PlayersModule {
    @Singleton
    @Binds
    abstract fun bindPlayerRepository(repository: PlayerRepository): IPlayerRepository

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSource: PlayerLocalDataSource): IPlayerLocalDataSource

    @Singleton
    @Binds
    abstract fun bindPlayerRemote(remote: PlayerRemoteDataSource): IPlayerRemoteDataSource
}