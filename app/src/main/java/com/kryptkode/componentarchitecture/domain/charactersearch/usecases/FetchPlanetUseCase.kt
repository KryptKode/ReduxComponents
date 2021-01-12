package com.kryptkode.componentarchitecture.domain.charactersearch.usecases

import com.kryptkode.componentarchitecture.domain.charactersearch.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.componentarchitecture.domain.charactersearch.dispatchers.AppDispatchers
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Planet
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Planet.Companion.NO_PLANET
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchPlanetUseCase @Inject constructor(private val dispatchers: AppDispatchers,
                                             private val repository: CharacterDetailRepository
) {

    fun fetchPlanet(planetUrl: String): Flow<Planet> {
        if(planetUrl.isEmpty()){
            return flowOf(NO_PLANET)
        }
        return repository.fetchPlanet(planetUrl).flowOn(dispatchers.io)
    }


}