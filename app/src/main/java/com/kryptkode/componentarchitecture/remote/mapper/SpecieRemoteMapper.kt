package com.kryptkode.componentarchitecture.remote.mapper

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Specie
import com.kryptkode.componentarchitecture.remote.entities.specie.SpecieRemote
import com.kryptkode.remote.mapper.DataEntityMapper
import javax.inject.Inject

class SpecieRemoteMapper @Inject constructor() : DataEntityMapper<SpecieRemote, Specie> {

    override fun mapToEntity(remote: SpecieRemote): Specie {
        return Specie(
            remote.name,
            remote.language,
            remote.homeWorld ?: ""
        )
    }
}