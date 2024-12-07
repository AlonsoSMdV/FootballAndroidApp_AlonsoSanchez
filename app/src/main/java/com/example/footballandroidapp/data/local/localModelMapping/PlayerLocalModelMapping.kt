package com.example.footballandroidapp.data.local.localModelMapping

import com.example.footballandroidapp.data.local.entities.PlayerE
import com.example.footballandroidapp.data.models.players.Player

fun Player.toLocal() = PlayerE(
    id = this.id,
    name = this.name,
    firstSurname = this.firstSurname,
    secondSurname = this.secondSurname,
    birthdate = this.birthdate,
    nationality = this.nationality,
    dorsal = this.dorsal,
    position = this.position,
    teamId = this.teamId
)


fun List<Player>.toLocal(): List<PlayerE>{
    return  this.map { p -> p.toLocal() }
}

fun PlayerE.toExternal()= Player(
    id = this.id,
    name = this.name,
    firstSurname = this.firstSurname,
    secondSurname = this.secondSurname,
    birthdate = this.birthdate,
    nationality = this.nationality,
    dorsal = this.dorsal,
    position = this.position,
    teamId = this.teamId
)


fun List<PlayerE>.toExternal(): List<Player>{
    return map { playerEntity ->  playerEntity.toExternal() }}

