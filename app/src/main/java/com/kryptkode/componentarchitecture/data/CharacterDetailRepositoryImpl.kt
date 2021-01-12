package com.kryptkode.componentarchitecture.data

import com.kryptkode.componentarchitecture.domain.charactersearch.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Film
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Planet
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Specie
import com.kryptkode.componentarchitecture.remote.api.SwahPeeServiceApi
import com.kryptkode.componentarchitecture.remote.mapper.FilmRemoteMapper
import com.kryptkode.componentarchitecture.remote.mapper.PlanetRemoteMapper
import com.kryptkode.componentarchitecture.remote.mapper.SpecieRemoteMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterDetailRepositoryImpl @Inject constructor(
    private val serviceApi: SwahPeeServiceApi,
    private val filmRemoteMapper: FilmRemoteMapper,
    private val planetRemoteMapper: PlanetRemoteMapper,
    private val specieRemoteMapper: SpecieRemoteMapper
    ) : CharacterDetailRepository {

    override fun fetchFilms(urls: List<String>): Flow<List<Film>> {
        return flow {
            emit(urls.map { url ->
                serviceApi.getFilmDetails(url)
            }.map { film ->
                filmRemoteMapper.mapToEntity(film)
            })
        }
    }

    override fun fetchPlanet(planetUrl: String): Flow<Planet> {
        return flow {
            emit(planetRemoteMapper.mapToEntity(serviceApi.getPlanet(planetUrl)))
        }
    }

    override fun fetchSpecies(urls: List<String>): Flow<List<Specie>> {
        return flow {
            emit(urls.map { url ->
                serviceApi.getSpecieDetails(url)
            }.map { specie ->
                specieRemoteMapper.mapToEntity(specie)
            })
        }
    }
}