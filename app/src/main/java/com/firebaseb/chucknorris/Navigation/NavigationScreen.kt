package com.firebaseb.chucknorris.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.firebaseb.chucknorris.Navigation.Destination.Companion.getStartDestination
import com.firebaseb.chucknorris.View.FilterScreen
import com.firebaseb.chucknorris.View.JokeScreen
import com.firebaseb.chucknorris.ViewModel.ViewModelChuckNorris

@Composable
fun NavigationScreen(){
    val navController = rememberNavController()
    val viewModel = ViewModelChuckNorris()
    NavHost(
        navController = navController,
        startDestination = getStartDestination()
    ){
        composable(route = Destination.FilterScreen.route){
            if(viewModel.navJoke.value){
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(route = Destination.JokeScreen.route)
                }
                viewModel.navJoke.value = false
            }
            FilterScreen(
                viewModel = viewModel
            )
        }

        composable(route = Destination.JokeScreen.route){
            JokeScreen(
                viewModel = viewModel
            )
        }
    }
}


