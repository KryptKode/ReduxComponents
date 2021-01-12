package com.kryptkode.componentarchitecture.domain.charactersearch.entities

data class Planet(
        val name: String,
        val population: String
) {
    companion object {
        val NO_PLANET = Planet("", "")
    }
}