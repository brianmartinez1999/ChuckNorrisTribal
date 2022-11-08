package com.firebaseb.chucknorris.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firebaseb.chucknorris.Models.ResponseJokeRandom
import com.firebaseb.chucknorris.Network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelChuckNorris : ViewModel() {
    private val _filter = mutableStateListOf<String>()
    val filter : MutableList<String>  = _filter
    private val _joke = mutableStateListOf<ResponseJokeRandom>()
    val joke : MutableList<ResponseJokeRandom>  = _joke
    val navJoke = mutableStateOf(false)

    init {
        GetApiFilter()
    }

    fun GetApiFilter(){
        viewModelScope.launch(Dispatchers.IO) {
            val authApiService = RetrofitHelper.getAuthService()
            val responseService = authApiService.GetCategories()
            if(responseService.isSuccessful){
                _filter.clear()
                _filter += responseService.body()!!
            }
        }
    }

    fun GetJokeRandom(string: String){
        viewModelScope.launch(Dispatchers.Default) {
            val authApiService = RetrofitHelper.getAuthService()
            val responseService = authApiService.GetJokesRandom(
                category = string
            )
            if(responseService.isSuccessful){
                _joke.clear()
                _joke += responseService.body()!!
                navJoke.value = true
            }
        }
    }
}