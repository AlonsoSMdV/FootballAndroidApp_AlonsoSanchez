package com.example.footballandroidapp.data.local.localModelMapping

import com.example.footballandroidapp.data.local.entities.CompetitionE
import com.example.footballandroidapp.data.local.entities.TeamE
import com.example.footballandroidapp.data.models.comps.Competition
import com.example.footballandroidapp.data.models.teams.Team

fun Team.toLocal() = TeamE(
    id = this.id,
    name = this.name,
    compId = this.comId
)


fun List<Team>.toLocal(): List<TeamE>{
    return  this.map { c -> c.toLocal() }
}

fun TeamE.toExternal()= Team(
    id = this.id,
    name = this.name,
    comId = this.compId
)


fun List<TeamE>.toExternal(): List<Team>{
    return map { teamEntity ->  teamEntity.toExternal() }}