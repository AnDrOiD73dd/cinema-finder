package com.ateam.zuml.cinemafinder.favorites;

import com.ateam.zuml.cinemafinder.database.room.daos.FavoritesDao;
import com.ateam.zuml.cinemafinder.database.room.daos.MoviesDao;
import com.ateam.zuml.cinemafinder.mapper.FavoritesMapper;
import com.ateam.zuml.cinemafinder.mapper.MovieMapper;
import com.ateam.zuml.cinemafinder.model.movie.BaseMovieModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class FavoritesRepositoryImpl implements FavoritesRepository {

    private final MoviesDao moviesDao;
    private final FavoritesDao favoritesDao;
    private final MovieMapper movieMapper;
    private final FavoritesMapper favoritesMapper;

    @Inject
    FavoritesRepositoryImpl(final MoviesDao moviesDao, final FavoritesDao favoritesDao,
                            final MovieMapper movieMapper, final FavoritesMapper favoritesMapper) {
        this.moviesDao = moviesDao;
        this.favoritesDao = favoritesDao;
        this.movieMapper = movieMapper;
        this.favoritesMapper = favoritesMapper;
    }

    @Override
    public Single<List<MovieListModel>> getAllMovies() {
        return favoritesDao.getAllFavoriteMovies()
                .subscribeOn(Schedulers.io())
                .map(movieMapper::mapMovieEntities);
    }

    @Override
    public Completable addMovie(final BaseMovieModel movieModel) {
        return Completable.fromAction(() -> {
            favoritesDao.insert(favoritesMapper.mapMovieListModel(movieModel));
            final int id = Integer.parseInt(movieModel.getId());
            final Disposable disposable = moviesDao.getMovieById(id)
                    .subscribe(movieEntity -> {
                            },
                            throwable -> {
                            },
                            () -> moviesDao.insert(movieMapper.mapMovieModel(movieModel)));
            disposable.dispose();
        })
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Completable removeMovie(final String id) {
        return Completable.fromAction(() -> favoritesDao.delete(favoritesMapper.mapModelId(id)))
                .subscribeOn(Schedulers.io());
    }
}