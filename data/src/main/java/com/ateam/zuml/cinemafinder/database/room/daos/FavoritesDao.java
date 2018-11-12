package com.ateam.zuml.cinemafinder.database.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ateam.zuml.cinemafinder.database.room.model.favorite.FavoriteEntity;
import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface FavoritesDao {

    @Query("SELECT * FROM movies WHERE id IN (SELECT movieId FROM favorites);")
    Single<List<MovieEntity>> getAllMoviesByFavoriteId();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FavoriteEntity entity);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllMovies(List<FavoriteEntity> entities);

    @Delete
    void delete(FavoriteEntity entity);

    @Query("DELETE FROM favorites")
    void deleteAllMovies();
}