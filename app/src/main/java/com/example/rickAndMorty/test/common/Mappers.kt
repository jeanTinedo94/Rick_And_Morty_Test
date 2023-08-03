package com.example.rickAndMorty.test.common

import com.example.rickAndMorty.test.data.model.characters.*
import com.example.rickAndMorty.test.domain.model.CharactersDataModel
import com.example.rickAndMorty.test.domain.model.characters.*
import com.example.rickAndMorty.test.domain.model.characters.Result

fun ResultDTO.toDomain(): Result {
    return Result(
        name= name?:"",
        status = status?:"",
        species = species?:"",
        type = type?:"",
        gender = gender?:"",
        origin = origin?.toDomain()?: Origin("",""),
        location = location?.toDomain()?: Location("",""),
        image = image?:"",
        episode = episode?: emptyList(),
    )

}
fun InfoDTO.toDomain():Info{
    return Info(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}

fun CharactersDataModelDTO.toDomain(): CharactersDataModel? {
    return results?.map {
        it.toDomain()
    }?.let {
        CharactersDataModel(
        info = info?.toDomain(),
        results = it
    )
    }
}


fun LocationDTO.toDomain(): Location {
    return Location(
        name= name?:"",
        url= url?:""
    )
}

fun OriginDTO.toDomain(): Origin {
    return Origin(
        name= name?:"",
        url= url?:""
    )
}
