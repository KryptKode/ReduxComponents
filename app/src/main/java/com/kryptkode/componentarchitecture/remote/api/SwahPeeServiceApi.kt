package com.kryptkode.componentarchitecture.remote.api

import com.kryptkode.componentarchitecture.remote.entities.character.CharacterResponse
import com.kryptkode.componentarchitecture.remote.entities.film.FilmRemote
import com.kryptkode.componentarchitecture.remote.entities.planet.PlanetRemote
import com.kryptkode.componentarchitecture.remote.entities.specie.SpecieRemote
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface SwahPeeServiceApi {

    @GET("people/")
    suspend fun searchCharacters(@Query("search") params: String): CharacterResponse

    @GET
    suspend fun getSpecieDetails(@Url speciesUrl: String): SpecieRemote

    @GET
    suspend fun getFilmDetails(@Url filmsUrl: String): FilmRemote

    @GET
    suspend fun getPlanet(@Url planetUrl: String): PlanetRemote
}