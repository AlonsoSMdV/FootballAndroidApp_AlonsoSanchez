package com.example.footballandroidapp.data.models.comps


import com.example.footballandroidapp.data.remote.comps.CompRaw

fun CompRaw.toExternal():Competition {
    return Competition(
        id = this.id.toString(),
        name = this.attributes.name
    )
}
fun List<CompRaw>.toExternal():List<Competition> = map(CompRaw::toExternal)