package com.ateam.zuml.cinemafinder.favorites;

import com.ateam.zuml.cinemafinder.database.room.MovieDatabase;
import com.ateam.zuml.cinemafinder.database.room.daos.FavoritesDao;
import com.ateam.zuml.cinemafinder.mapper.MovieMapper;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class FavoritesRepositoryImpl implements FavoritesRepository {

    private final FavoritesDao db;
    private final MovieMapper movieMapper;

    @Inject
    public FavoritesRepositoryImpl(MovieDatabase movieDatabase, final MovieMapper movieMapper) {
        this.db = movieDatabase.favoritesDao();
        this.movieMapper = movieMapper;
    }

    @Override
    public Single<List<MovieDetailsModel>> getAllMovies(final LogoSize logoSize) {
        return db.getAllMoviesByFavoriteId()
                .subscribeOn(Schedulers.io())
                .map(movieEntities -> movieMapper.mapMovieDetailsFromMovieEntity(movieEntities, logoSize));
    }

    @Override
    public void addMovie(MovieDetailsModel movieDetailsModel) {
        db.insert(movieMapper.mapFavoriteEntityFromMovieDetailsModel(movieDetailsModel));
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