package com.example.rickAndMorty.test.domain.useCases

import com.example.rickAndMorty.test.domain.model.CharactersDataModel
import com.example.rickAndMorty.test.domain.repository.CharacterRepo
import com.example.rickAndMorty.test.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetFilterCharactersUseCase(private val characters: CharacterRepo) {
    operator fun invoke(nameCharacter: String?,
                        statusCharacter: String?,
                        speciesCharacter: String?,
                        typeCharacter: String?,
                        genderCharacter: String?): Flow<Result<CharactersDataModel>> = flow{
        emit(Result.Loading())
        try{
            emit(
                Result.Success(data = characters.getFilterCharacters(nameCharacter,
                statusCharacter,
                speciesCharacter,
            typeCharacter,
            genderCharacter)))
        }catch (e:java.lang.Exception){
            emit(Result.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}