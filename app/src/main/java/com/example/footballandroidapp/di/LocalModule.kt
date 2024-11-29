package com.example.footballandroidapp.di

import android.content.Context
import androidx.room.Room
import com.example.footballandroidapp.data.local.database.AppDatabase
import com.example.footballandroidapp.data.local.database.CompetitionDao
import com.example.footballandroidapp.data.local.database.PlayerDao
import com.example.footballandroidapp.data.local.database.TeamDao
import com.example.footballandroidapp.data.local.database.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule{

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideCompDao(database: AppDatabase): CompetitionDao {
        return database.compDao()
    }

    @Provides
    @Singleton
    fun provideTeamDao(database: AppDatabase): TeamDao {
        return database.teamDao()
    }

    @Provides
    @Singleton
    fun providePlayerDao(database: AppDatabase): PlayerDao {
        return database.playerDao()
    }
}