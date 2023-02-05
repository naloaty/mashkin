package me.naloaty.fintechmovies.presentation

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import me.naloaty.fintechmovies.App

abstract class BaseFragment(@LayoutRes layout: Int): Fragment(layout) {

    protected val presentationComponent by lazy {
        (requireActivity().application as App)
            .appComponent
            .presentationComponentBuilder()
            .activity(requireActivity())
            .build()
    }

}