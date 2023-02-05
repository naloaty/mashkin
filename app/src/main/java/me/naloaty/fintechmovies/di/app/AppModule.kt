package me.naloaty.fintechmovies.di.app

import android.app.Application
import dagger.Module
import dagger.Provides
import me.naloaty.fintechmovies.di.presentation.PresentationComponent

@Module(
    subcomponents = [PresentationComponent::class]
)
class AppModule {

}