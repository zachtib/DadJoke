package com.zachtib.dadjoke

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get<DadJokeViewModel>()

        viewModel.joke.observe(this, Observer {
            jokeTextView.text = it
        })

        newJokeButton.setOnClickListener {
            viewModel.newJokeButtonClicked()
        }
    }
}