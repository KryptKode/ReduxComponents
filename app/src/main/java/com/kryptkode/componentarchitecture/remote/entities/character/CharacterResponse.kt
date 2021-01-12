package com.kryptkode.componentarchitecture.remote.entities.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @field:Json(name = "results") val results: List<CharacterRemote>
)