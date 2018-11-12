package com.ateam.zuml.cinemafinder.di.modules;

import com.ateam.zuml.cinemafinder.favorites.FavoritesRepositoryImpl;
import com.ateam.zuml.cinemafinder.movies.MoviesRepositoryImpl;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface DataModule {

    @Singleton
    @Binds
    MoviesRepository provideMoviesRepository(final MoviesRepositoryImpl repository);

    @Singleton
    @Binds
    FavoritesRepository provideFavoritesRepository(final FavoritesRepositoryImpl mapper);
}
