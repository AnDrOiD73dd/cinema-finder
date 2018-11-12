package com.ateam.zuml.cinemafinder.interactor.favorites;

import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class AddFavoriteMovieUseCase {

    private final FavoritesRepository favoritesRepository;

    @Inject
    public AddFavoriteMovieUseCase(final FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public void execute()   {

    }
}
