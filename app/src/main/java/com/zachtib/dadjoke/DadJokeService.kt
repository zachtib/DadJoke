package com.zachtib.dadjoke

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class DadJokeService {
    private val api = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://icanhazdadjoke.com")
        .build()
        .create<DadJokeApi>()

    suspend fun getRandomJoke(): DadJoke {
        return api.getJoke()
    }
}
