package com.ateam.zuml.cinemafinder.interactor.favorites;

import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class GetFavoriteMoviesUseCase {

    private final FavoritesRepository favoritesRepository;

    @Inject
    public GetFavoriteMoviesUseCase(final FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public Single<List<MovieDetailsModel>> execute()   {
        return null;
    }
}
