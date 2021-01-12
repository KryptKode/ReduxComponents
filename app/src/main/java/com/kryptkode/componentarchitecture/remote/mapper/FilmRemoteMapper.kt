package com.kryptkode.componentarchitecture.remote.mapper

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Film
import com.kryptkode.componentarchitecture.remote.entities.film.FilmRemote
import com.kryptkode.remote.mapper.DataEntityMapper
import javax.inject.Inject

class FilmRemoteMapper @Inject constructor() : DataEntityMapper<FilmRemote, Film> {

    override fun mapToEntity(remote: FilmRemote): Film {
        return Film(
            remote.title,
            remote.openingCrawl,
        )
    }
}