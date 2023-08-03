package com.example.rickAndMorty.test.presentation.character.model

import com.example.rickAndMorty.test.domain.model.CharactersDataModel

data class CharacterListState(
    val loading:Boolean= false,
    val error:String = "",
    val data: CharactersDataModel?=null
)