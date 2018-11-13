package com.ateam.zuml.cinemafinder.interactor.favorites;

import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;

@Singleton
public final class RemoveFavoriteMovieUseCase {

    private final FavoritesRepository favoritesRepository;

    @Inject
    public RemoveFavoriteMovieUseCase(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public Completable execute(final String movieId) {
        return favoritesRepository.removeMovie(movieId);
    }
}
