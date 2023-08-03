package com.example.rickAndMorty.test.data.model.characters

import java.util.*


data class ResultDTO(
    val id: Int? = 0,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val origin: OriginDTO? = null,
    val location: LocationDTO? = null,
    val image: String? = null,
    val episode: List<String>? = null,
    val url: String? = null,
    val created: Date? = null,
)