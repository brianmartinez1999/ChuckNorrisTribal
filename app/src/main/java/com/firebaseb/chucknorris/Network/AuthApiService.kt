package com.firebaseb.chucknorris.Network

import com.firebaseb.chucknorris.Models.ResponseJokeRandom
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApiService {

    @GET("/jokes/categories")
    suspend fun GetCategories(): Response<ArrayList<String>>

    @GET("jokes/random")
    suspend fun GetJokesRandom(
        @Query("category") category : String
    ): Response<ResponseJokeRandom>

}