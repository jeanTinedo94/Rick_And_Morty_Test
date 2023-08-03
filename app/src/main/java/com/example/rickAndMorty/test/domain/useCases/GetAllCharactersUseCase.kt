package com.example.rickAndMorty.test.domain.useCases

import com.example.rickAndMorty.test.domain.model.CharactersDataModel
import com.example.rickAndMorty.test.domain.repository.CharacterRepo
import com.example.rickAndMorty.test.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetAllCharactersUseCase(private val characters: CharacterRepo) {
    operator fun invoke(page:String): Flow<Result<CharactersDataModel>> = flow{
        emit(Result.Loading())
        try{
            emit(Result.Success(data = characters.getAllCharacters(page)))
        }catch (e:java.lang.Exception){
            emit(Result.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}