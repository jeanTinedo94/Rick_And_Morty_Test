package com.example.rickAndMorty.test.presentation.character.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickAndMorty.test.domain.useCases.GetAllCharactersUseCase
import com.example.rickAndMorty.test.domain.useCases.GetFilterCharactersUseCase
import com.example.rickAndMorty.test.presentation.character.model.CharacterListState
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.rickAndMorty.test.common.Result
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val filterCharactersUseCase: GetFilterCharactersUseCase
) :ViewModel() {

        private val _characterList= mutableStateOf(CharacterListState())
        val characterList= _characterList

    init {
        getAllCharacters()
    }


    private fun getAllCharacters(page:String= ""){
        getAllCharactersUseCase(page).onEach {
            model->
            when (model){
                is Result.Loading -> {
                    _characterList.value= CharacterListState(loading = true)
                }
                is Result.Success -> {
                    _characterList.value=CharacterListState(data =model.data)
                }
                is Result.Error -> {
                    _characterList.value=CharacterListState(error = model.message)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getFilterCharacters(nameCharacter: String?,
                            statusCharacter: String?,
                            speciesCharacter: String?,
                            typeCharacter: String?,
                            genderCharacter: String?){
        filterCharactersUseCase(nameCharacter,statusCharacter,speciesCharacter,typeCharacter,genderCharacter).onEach {
                model->
            when (model){
                is Result.Loading -> {
                    _characterList.value= CharacterListState(loading = true)
                }
                is Result.Success -> {
                    _characterList.value=CharacterListState(data =model.data)
                }
                is Result.Error -> {
                    _characterList.value=CharacterListState(error = model.message)
                }
            }
        }.launchIn(viewModelScope)
    }

}