package me.naloaty.fintechmovies

import android.app.Application
import me.naloaty.fintechmovies.di.app.DaggerAppComponent

class App: Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}