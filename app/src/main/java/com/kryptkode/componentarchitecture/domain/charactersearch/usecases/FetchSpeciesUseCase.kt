package com.kryptkode.componentarchitecture.domain.charactersearch.usecases

import com.kryptkode.componentarchitecture.domain.charactersearch.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.componentarchitecture.domain.charactersearch.dispatchers.AppDispatchers
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Specie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchSpeciesUseCase @Inject constructor(
    private val dispatchers: AppDispatchers,
    private val repository: CharacterDetailRepository
) {
    fun fetchSpecies(urls: List<String>): Flow<List<Specie>> {
        if (urls.isEmpty()) {
            return flowOf(emptyList())
        }
        return repository.fetchSpecies(urls).flowOn(dispatchers.io)
    }


}