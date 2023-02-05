package me.naloaty.fintechmovies.presentation

import android.os.Bundle
import me.naloaty.fintechmovies.R

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        presentationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}