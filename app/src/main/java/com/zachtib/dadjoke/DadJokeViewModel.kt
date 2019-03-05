package com.zachtib.dadjoke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DadJokeViewModel : ViewModel(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val service = DadJokeService()

    private val _joke = MutableLiveData<String>()

    val joke: LiveData<String>
        get() = _joke

    init {
        showRandomJoke()
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    private fun showRandomJoke() {
        launch {
            val newJoke = service.getRandomJoke()
            _joke.postValue(newJoke.joke)
        }
    }

    fun newJokeButtonClicked() = showRandomJoke()
}
