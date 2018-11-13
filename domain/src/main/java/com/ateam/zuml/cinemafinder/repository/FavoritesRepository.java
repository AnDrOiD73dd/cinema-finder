package com.ateam.zuml.cinemafinder.repository;

import com.ateam.zuml.cinemafinder.model.movie.BaseMovieModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface FavoritesRepository {

    Single<List<MovieListModel>> getAllMovies();

    Completable addMovie(final BaseMovieModel movieModel);

    Completable removeMovie(final String id);
}
