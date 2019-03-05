package com.zachtib.dadjoke

import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeApi {
    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getJoke(): DadJoke
}