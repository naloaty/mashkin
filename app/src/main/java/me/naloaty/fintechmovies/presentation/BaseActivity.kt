package me.naloaty.fintechmovies.presentation


import androidx.fragment.app.FragmentActivity
import me.naloaty.fintechmovies.App

abstract class BaseActivity: FragmentActivity() {

    protected val presentationComponent by lazy {
        (application as App)
            .appComponent
            .presentationComponentBuilder()
            .activity(this)
            .build()
    }

}