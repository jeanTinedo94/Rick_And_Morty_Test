package com.example.rickAndMorty.test.domain.model.characters

data class Result(
    val name:String,
    val status:String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
)
