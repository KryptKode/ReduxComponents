package com.kryptkode.componentarchitecture.data.remote

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Film
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Planet
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Specie


interface CharacterDetailRemote {
    suspend fun fetchPlanet(planetUrl: String): Planet

    suspend fun fetchSpecies(urls: List<String>): List<Specie>

    suspend fun fetchFilms(urls: List<String>): List<Film>
}