package com.ateam.zuml.cinemafinder.repository;

import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;

import java.util.List;

import io.reactivex.Single;

public interface FavoritesRepository {

    Single<List<MovieDetailsModel>> getAllMovies(final LogoSize logoSize);

    void addMovie(MovieDetailsModel movieDetailsModel);

    void addAllMovies(List<MovieDetailsModel> movieDetailsModels);

    void removeMovie(MovieDetailsModel movieDetailsModel);

    void removeAllMovies(List<MovieDetailsModel> movieDetailsModels);
}
