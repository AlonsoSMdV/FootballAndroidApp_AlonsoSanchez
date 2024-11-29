package com.example.footballandroidapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballandroidapp.data.local.entities.CompetitionE
import com.example.footballandroidapp.data.local.entities.PlayerE
import com.example.footballandroidapp.data.local.entities.TeamE
import com.example.footballandroidapp.data.local.entities.User

@Database(entities = [User::class,
                      CompetitionE::class,
                      TeamE::class,
                      PlayerE::class],
                      version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun compDao(): CompetitionDao
    abstract fun teamDao(): TeamDao
    abstract fun playerDao(): PlayerDao
}