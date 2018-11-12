package com.ateam.zuml.cinemafinder.interactor.favorites;

import com.ateam.zuml.cinemafinder.model.movie.BaseMovieModel;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;

@Singleton
public final class AddFavoriteMovieUseCase {

    private final FavoritesRepository favoritesRepository;

    @Inject
    public AddFavoriteMovieUseCase(final FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public Completable execute(final BaseMovieModel movieModel) {
        return favoritesRepository.addMovie(movieModel);
    }
}
