package com.kryptkode.componentarchitecture.domain.charactersearch.usecases

import com.kryptkode.componentarchitecture.domain.charactersearch.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.componentarchitecture.domain.charactersearch.dispatchers.AppDispatchers
import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Film
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchFilmsUseCase @Inject constructor(
    private val appDispatchers: AppDispatchers,
    private val repository: CharacterDetailRepository
) {

    fun fetchFilms(urls: List<String>): Flow<List<Film>> {
        if (urls.isEmpty()) {
            return flowOf(emptyList())
        }
        return repository.fetchFilms(urls).flowOn(appDispatchers.io)
    }
}