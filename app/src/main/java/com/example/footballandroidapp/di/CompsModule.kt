package com.example.footballandroidapp.di

import com.example.footballandroidapp.data.local.iLocalDataSource.ICompsLocalDataSource
import com.example.footballandroidapp.data.local.localDataSource.CompsLocalDataSource
import com.example.footballandroidapp.data.models.comps.CompsRepository
import com.example.footballandroidapp.data.models.comps.ICompsRepository
import com.example.footballandroidapp.data.remote.comps.CompsRemoteDataSource
import com.example.footballandroidapp.data.remote.comps.ICompRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CompsModule {
    @Singleton
    @Binds
    abstract fun bindCompsRepository(repository: CompsRepository): ICompsRepository

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSource: CompsLocalDataSource): ICompsLocalDataSource

    @Singleton
    @Binds
    abstract fun bindCompRemote(remote: CompsRemoteDataSource): ICompRemoteDataSource
}