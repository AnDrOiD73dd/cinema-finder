package com.ateam.zuml.cinemafinder.repository;

import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface FavoritesRepository {

    Single<List<MovieListModel>> getAllMovies();

    Completable addMovie(final MovieListModel movieDetailsModel);

    Completable addMovie(final MovieDetailsModel movieDetailsModel);

    Completable removeMovie(final int id);
}
