package com.example.footballandroidapp.data.models.teams

import com.example.footballandroidapp.data.remote.teams.TeamRaw

fun TeamRaw.toExternal(): Team {
    return Team(
        id = this.id.toString(),
        name = this.attributes.name,
        comId = this.attributes.compId.toString()
    )
}
fun List<TeamRaw>.toExternal():List<Team> = map(TeamRaw::toExternal)