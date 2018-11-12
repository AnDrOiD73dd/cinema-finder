package com.ateam.zuml.cinemafinder.favorites;

import com.ateam.zuml.cinemafinder.database.room.MovieDatabase;
import com.ateam.zuml.cinemafinder.database.room.daos.FavoritesDao;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class FavoritesRepositoryImpl implements FavoritesRepository {

    private final FavoritesDao db;

    @Inject
    public FavoritesRepositoryImpl(MovieDatabase movieDatabase) {
        this.db = movieDatabase.favoritesDao();
    }

    @Override
    public Single<List<MovieDetailsModel>> getAllMovies(int movieId) {
        return null;
    }

    @Override
    public void addMovie(MovieDetailsModel movieDetailsModel) {

    }

    @Override
    public void addAllMovies(List<MovieDetailsModel> movieDetailsModels) {

    }

    @Override
    public void removeMovie(MovieDetailsModel movieDetailsModel) {

    }

    @Override
    public void removeAllMovies(List<MovieDetailsModel> movieDetailsModels) {

    }
}