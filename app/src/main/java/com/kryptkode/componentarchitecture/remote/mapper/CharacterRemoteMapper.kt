package com.kryptkode.componentarchitecture.remote.mapper

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.componentarchitecture.remote.entities.character.CharacterRemote
import com.kryptkode.remote.mapper.DataEntityMapper
import javax.inject.Inject

class CharacterRemoteMapper @Inject constructor() :
    DataEntityMapper<CharacterRemote, CharacterInfo> {

    override fun mapToEntity(remote: CharacterRemote): CharacterInfo {
        return CharacterInfo(
            remote.name,
            remote.url,
            remote.birthYear,
            remote.height,
            remote.homeWorld,
            remote.films,
            remote.species
        )
    }
}