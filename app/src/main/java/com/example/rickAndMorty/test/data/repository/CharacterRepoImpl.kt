package com.example.rickAndMorty.test.data.repository

import androidx.paging.PagingData
import com.example.rickAndMorty.test.common.toDomain
import com.example.rickAndMorty.test.data.network.ApiService
import com.example.rickAndMorty.test.domain.model.CharactersDataModel
import com.example.rickAndMorty.test.domain.repository.CharacterRepo
import kotlinx.coroutines.flow.Flow

class CharacterRepoImpl(private val apiService: ApiService): CharacterRepo {
    override suspend fun getAllCharacters(page: String?): CharactersDataModel? {
        return apiService.getAllCharacters(page).toDomain()
    }


    override suspend fun getFilterCharacters(
        nameCharacter: String?,
        statusCharacter: String?,
        speciesCharacter: String?,
        typeCharacter: String?,
        genderCharacter: String?,
    ): CharactersDataModel? {
        return apiService.getFilterCharacters(
            nameCharacter,
            statusCharacter,
            speciesCharacter,
            typeCharacter,
            genderCharacter).toDomain()
    }
}