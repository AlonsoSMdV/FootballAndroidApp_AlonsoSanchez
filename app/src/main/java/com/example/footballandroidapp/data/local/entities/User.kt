package com.example.footballandroidapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey val id: Int,
    val username: String,
    val email: String,
    val token: String? = null
)

data class LoginRes(
    val jwt: String,
    val user: User
)

data class RegisterRes(
    val jwt: String,
    val user: User
)