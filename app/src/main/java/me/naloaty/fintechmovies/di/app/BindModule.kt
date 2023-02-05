package me.naloaty.fintechmovies.di.app

import dagger.Binds
import dagger.Module
import me.naloaty.fintechmovies.data.repository.KinopoiskMoviesRepositoryImpl
import me.naloaty.fintechmovies.domain.repository.MoviesRepository

@Module
interface BindModule {

    @Binds
    fun bindMoviesRepository(impl: KinopoiskMoviesRepositoryImpl): MoviesRepository
}