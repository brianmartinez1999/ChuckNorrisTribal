package com.firebaseb.chucknorris.Navigation

sealed class Destination ( val route : String){
    object FilterScreen : Destination(route = "filterscreen")
    object JokeScreen : Destination(route = "jokescreen")

    companion object {
        fun getStartDestination() = FilterScreen.route
    }
}

