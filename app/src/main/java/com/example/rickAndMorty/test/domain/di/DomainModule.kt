package com.example.rickAndMorty.test.domain.di

import com.example.rickAndMorty.test.domain.repository.CharacterRepo
import com.example.rickAndMorty.test.domain.useCases.GetAllCharactersUseCase
import com.example.rickAndMorty.test.domain.useCases.GetFilterCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun getAllCharactersUseCase(characterRepo: CharacterRepo): GetAllCharactersUseCase {
        return GetAllCharactersUseCase(characterRepo)
    }


    @Provides
    fun getFilterCharactersUseCase(characterRepo: CharacterRepo): GetFilterCharactersUseCase {
        return GetFilterCharactersUseCase(characterRepo)
    }

}