package com.example.rickAndMorty.test.presentation.navigation

import androidx.navigation.Navigation

sealed class NavigationItem(val route:String){
    object CharacterListNavigationItem:NavigationItem("characterScreen")
}
