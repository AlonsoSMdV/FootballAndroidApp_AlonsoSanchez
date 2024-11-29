package com.example.footballandroidapp.data.local.localModelMapping


import com.example.footballandroidapp.data.local.entities.CompetitionE
import com.example.footballandroidapp.data.models.comps.Competition

fun Competition.toLocal() = CompetitionE(
    id = this.id,
    name = this.name
)


fun List<Competition>.toLocal(): List<CompetitionE>{
    return  this.map { c -> c.toLocal() }
}

fun CompetitionE.toExternal()= Competition(
    id = this.id,
    name = this.name
)


fun List<CompetitionE>.toExternal(): List<Competition>{
    return map { compEntity ->  compEntity.toExternal() }}