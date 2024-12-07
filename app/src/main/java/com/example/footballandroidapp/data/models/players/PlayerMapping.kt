package com.example.footballandroidapp.data.models.players

import com.example.footballandroidapp.data.remote.players.PlayerRaw

fun PlayerRaw.toExternal(): Player {
    return Player(
        id = this.id.toString(),
        name = this.attributes.name,
        firstSurname = this.attributes.firstSurname,
        secondSurname = this.attributes.secondSurname,
        nationality = this.attributes.nationality,
        dorsal = this.attributes.dorsal,
        position = this.attributes.position,
        teamId = this.attributes.teamId.toString(),
        birthdate = this.attributes.birthdate
    )
}
fun List<PlayerRaw>.toExternal():List<Player> = map(PlayerRaw::toExternal)