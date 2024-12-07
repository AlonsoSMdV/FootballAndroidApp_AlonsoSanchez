package com.example.footballandroidapp.data.remote.players

data class PlayerRaw (
    val id: Int,
    val attributes: PlayerRawAttributes
)

data class PlayerRawAttributes(
    val name: String,
    val firstSurname: String,
    val secondSurname: String?,
    val nationality: String,
    val dorsal: Int,
    val birthdate: String,
    val position: String,
    val teamId: Int,
    val createdAt: String
)

data class PlayerCreate(val attributes: PlayerRawAttributes)