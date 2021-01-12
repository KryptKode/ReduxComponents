package com.kryptkode.componentarchitecture.domain.charactersearch.repo

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.CharacterInfo
import kotlinx.coroutines.flow.Flow

interface SearchCharactersRepository {
    fun searchCharacters(query: String): Flow<List<CharacterInfo>>

}