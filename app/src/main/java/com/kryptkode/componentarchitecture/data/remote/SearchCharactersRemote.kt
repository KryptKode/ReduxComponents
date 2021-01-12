package com.kryptkode.componentarchitecture.data.remote

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.CharacterInfo

interface SearchCharactersRemote {
    suspend fun searchCharacters(query: String): List<CharacterInfo>
}