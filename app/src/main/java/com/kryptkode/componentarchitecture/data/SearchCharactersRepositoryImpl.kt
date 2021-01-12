package com.kryptkode.componentarchitecture.data

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.componentarchitecture.domain.charactersearch.repo.SearchCharactersRepository
import com.kryptkode.componentarchitecture.remote.api.SwahPeeServiceApi
import com.kryptkode.componentarchitecture.remote.mapper.CharacterRemoteMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCharactersRepositoryImpl @Inject constructor(
    private val serviceApi: SwahPeeServiceApi,
    private val mapper: CharacterRemoteMapper
) : SearchCharactersRepository {

    override fun searchCharacters(query: String): Flow<List<CharacterInfo>> {
        return flow {
            emit(serviceApi.searchCharacters(query).results.map { character ->
                mapper.mapToEntity(character)
            })
        }
    }
}