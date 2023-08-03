package com.example.rickAndMorty.test.data.network

import com.example.rickAndMorty.test.data.model.characters.CharactersDataModelDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getAllCharacters(
        @Query("page") page:String?= null
    ):CharactersDataModelDTO

    @GET("character/")
    suspend fun getFilterCharacters(
        @Query("name") nameCharacter:String?= null,
        @Query("status") statusCharacter:String?= null,
        @Query("species") speciesCharacter:String?= null,
        @Query("type") typeCharacter:String?= null,
        @Query("gender") genderCharacter:String?= null,
        ):CharactersDataModelDTO

}