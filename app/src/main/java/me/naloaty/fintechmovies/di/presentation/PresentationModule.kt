package me.naloaty.fintechmovies.di.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class PresentationModule {

    @Provides
    fun provideContext(activity: AppCompatActivity): Context = activity

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager

}