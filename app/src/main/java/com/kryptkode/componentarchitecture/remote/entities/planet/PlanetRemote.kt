package com.kryptkode.componentarchitecture.remote.entities.planet

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlanetRemote(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "population") val population: String
)