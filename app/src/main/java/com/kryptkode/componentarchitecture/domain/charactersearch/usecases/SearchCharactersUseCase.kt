package com.kryptkode.componentarchitecture.domain.charactersearch.usecases

import com.kryptkode.componentarchitecture.domain.charactersearch.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.componentarchitecture.domain.charactersearch.dispatchers.AppDispatchers
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Character
import com.kryptkode.componentarchitecture.domain.charactersearch.repo.SearchCharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchCharactersUseCase @Inject constructor(
    private val appDispatchers: AppDispatchers,
    private val characterDetailRepository: CharacterDetailRepository,
    private val searchCharactersRepository: SearchCharactersRepository
) {
    fun searchCharacters(query: String): Flow<List<Character>> {
        return searchCharactersRepository.searchCharacters(query).map { list ->
                list.map { Character(it.name, it.birthYear, it.height, it.url) }
            }
            .flowOn(appDispatchers.io)
    }
}