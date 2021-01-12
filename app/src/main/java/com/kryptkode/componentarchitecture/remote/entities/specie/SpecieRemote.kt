package com.kryptkode.componentarchitecture.remote.entities.specie

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpecieRemote(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "language") val language: String,
    @field:Json(name = "homeworld") val homeWorld: String?=""
)