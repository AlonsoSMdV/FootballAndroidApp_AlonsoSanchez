package com.example.footballandroidapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamE (
    @PrimaryKey
    val id: String,
    val name: String,
    val compId: String
)