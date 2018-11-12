package com.ateam.zuml.cinemafinder.favorites;

import com.ateam.zuml.cinemafinder.database.room.MovieDatabase;
import com.ateam.zuml.cinemafinder.database.room.daos.FavoritesDao;
import com.ateam.zuml.cinemafinder.mapper.MovieMapper;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;

@Singleton
public class FavoritesRepositoryImpl implements FavoritesRepository {

    private final FavoritesDao db;
    private final MovieMapper movieMapper;

    @Inject
    public FavoritesRepositoryImpl(final MovieDatabase movieDatabase, final MovieMapper movieMapper) {
        this.db = movieDatabase.favoritesDao();
        this.movieMapper = movieMapper;
    }

    @Override
    public Single<List<MovieListModel>> getAllMovies() {
        return null;
    }

    @Override
    public Completable addMovie(MovieDetailsModel movieDetailsModel) {
        return Completable.complete();
    }

    @Override
    public Completable addMovie(MovieListModel movieDetailsModel) {
        return Completable.complete();
    }

    @Override
    public Completable removeMovie(int id) {
        return null;
    }
}