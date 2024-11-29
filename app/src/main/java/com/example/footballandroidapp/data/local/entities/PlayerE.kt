package com.example.footballandroidapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class PlayerE (
    @PrimaryKey val id: String,
    val name: String,
    val firstSurname: String,
    val secondSurname: String,
    val birthdate: String,
    val nationality: String,
    val dorsal: Int,
    val position: String,
    val teamId: String
)