package com.kryptkode.componentarchitecture.domain.charactersearch.charactersearch.repo

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Film
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Planet
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Specie
import kotlinx.coroutines.flow.Flow

interface CharacterDetailRepository {
    fun fetchPlanet(planetUrl: String): Flow<Planet>

    fun fetchSpecies(urls: List<String>): Flow<List<Specie>>

    fun fetchFilms(urls: List<String>): Flow<List<Film>>
}