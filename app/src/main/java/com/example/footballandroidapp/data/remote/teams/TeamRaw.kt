package com.example.footballandroidapp.data.remote.teams

import com.example.footballandroidapp.data.remote.comps.CompRawAttributes

data class TeamRaw(val id: Int,
                   val attributes: TeamRawAttributes
)

data class TeamRawAttributes(val name: String,
                             val compId: Int,
                             val createdAt: String
)
