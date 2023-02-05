package me.naloaty.fintechmovies.di.presentation

import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Subcomponent
import me.naloaty.fintechmovies.presentation.MainActivity
import me.naloaty.fintechmovies.presentation.popular.PopularMoviesFragment


@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(popularMoviesFragment: PopularMoviesFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: FragmentActivity): Builder
        fun build(): PresentationComponent
    }
}