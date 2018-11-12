package com.ateam.zuml.cinemafinder.interactor.favorites;

import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
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

    public Completable execute(final MovieListModel movieListModel) {
        return favoritesRepository.addMovie(movieListModel);
    }

    public Completable execute(final MovieDetailsModel movieDetailsModel) {
        return favoritesRepository.addMovie(movieDetailsModel);
    }
}
