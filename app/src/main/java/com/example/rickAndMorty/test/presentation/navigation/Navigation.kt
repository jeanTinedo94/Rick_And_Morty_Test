package com.example.rickAndMorty.test.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickAndMorty.test.presentation.character.view.CharacterViewScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.CharacterListNavigationItem.route){
        composable(NavigationItem.CharacterListNavigationItem.route){
            CharacterViewScreen()
        }
    }
}