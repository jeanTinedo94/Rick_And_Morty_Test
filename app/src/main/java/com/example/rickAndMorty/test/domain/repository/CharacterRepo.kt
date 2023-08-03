package com.example.rickAndMorty.test.domain.repository

import com.example.rickAndMorty.test.domain.model.CharactersDataModel

interface CharacterRepo {
    suspend fun getAllCharacters(page:String?= null): CharactersDataModel?

    suspend fun getFilterCharacters(
        nameCharacter:String?= null,
        statusCharacter:String?= null,
        speciesCharacter:String?= null,
        typeCharacter:String?= null,
        genderCharacter:String?= null,
    ): CharactersDataModel?
}