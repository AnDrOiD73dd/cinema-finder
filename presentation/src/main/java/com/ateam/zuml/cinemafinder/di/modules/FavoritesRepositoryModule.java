package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.favorites.FavoritesRepositoryImpl;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface FavoritesRepositoryModule {

    @Singleton
    @Binds
    FavoritesRepository provideFavoritesRepository(final FavoritesRepositoryImpl mapper);
}
