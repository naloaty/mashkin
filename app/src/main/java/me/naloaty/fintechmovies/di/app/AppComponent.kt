package me.naloaty.fintechmovies.di.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import me.naloaty.fintechmovies.di.presentation.PresentationComponent
import me.naloaty.fintechmovies.di.presentation.PresentationModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RetrofitModule::class,
        BindModule::class
    ]
)
interface AppComponent {

    fun presentationComponentBuilder(): PresentationComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }

}