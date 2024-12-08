package com.example.footballandroidapp.data.remote.comps

data class CompRaw (
    val id: Int,
    val attributes: CompRawAttributes
)

data class CompRawAttributes(
    val name:String
)

data class CompCreate(val data: CompRawAttributes)