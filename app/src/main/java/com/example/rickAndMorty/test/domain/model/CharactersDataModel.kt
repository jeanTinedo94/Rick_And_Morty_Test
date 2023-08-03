package com.example.rickAndMorty.test.domain.model

import com.example.rickAndMorty.test.domain.model.characters.Info
import com.example.rickAndMorty.test.domain.model.characters.Result

data class CharactersDataModel(
    val info: Info? = null,
    val results: List<Result>? = null
)
