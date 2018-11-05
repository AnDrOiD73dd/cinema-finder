package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.movies.MoviesRepositoryImpl;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface DataModule {

    @Singleton
    @Binds
    MoviesRepository provideMoviesRepository(final MoviesRepositoryImpl repository);
}
