package com.kryptkode.componentarchitecture.remote.entities.film

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmRemote(
    @field:Json(name = "title") val title: String,
    @field:Json(name = "opening_crawl") val openingCrawl: String
)