package com.kryptkode.componentarchitecture.domain.charactersearch.entities

data class CharacterInfo(
    val name: String,
    val url: String,
    val birthYear: String,
    val height: String,
    val homeWorld: String,
    val films: List<String>,
    val species: List<String>,
) {
    companion object {
        val NO_CHARACTER_INFO = CharacterInfo("", "", "", "", "", emptyList(), emptyList())
    }
}