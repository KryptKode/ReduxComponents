package com.kryptkode.componentarchitecture.remote.mapper

import com.kryptkode.componentarchitecture.domain.charactersearch.entities.Planet
import com.kryptkode.componentarchitecture.remote.entities.planet.PlanetRemote
import com.kryptkode.remote.mapper.DataEntityMapper
import javax.inject.Inject

class PlanetRemoteMapper @Inject constructor() : DataEntityMapper<PlanetRemote, Planet> {

    override fun mapToEntity(remote: PlanetRemote): Planet {
        return Planet(
            remote.name,
            remote.population,
        )
    }
}