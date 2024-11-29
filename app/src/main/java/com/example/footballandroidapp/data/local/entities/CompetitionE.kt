package com.example.footballandroidapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competition")
data class CompetitionE (
    @PrimaryKey val id: String,
    val name: String
)