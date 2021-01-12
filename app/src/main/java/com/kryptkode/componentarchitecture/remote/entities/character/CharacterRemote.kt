package com.kryptkode.componentarchitecture.remote.entities.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterRemote(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "birth_year") val birthYear: String,
    @field:Json(name = "height") val height: String,
    @field:Json(name = "films") val films: List<String>,
    @field:Json(name = "homeworld") val homeWorld: String,
    @field:Json(name = "species") val species: List<String>,
    @field:Json(name = "url") val url: String
)