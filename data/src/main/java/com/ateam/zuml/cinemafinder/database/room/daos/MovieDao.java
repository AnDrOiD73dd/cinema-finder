package com.ateam.zuml.cinemafinder.database.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;
import com.ateam.zuml.cinemafinder.database.room.model.enums.MovieCollectionType;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieEntity movie);

    @Update
    void update(MovieEntity movie);

    @Query("DELETE FROM movies")
    void deleteAllMovies();

    @Query("SELECT * FROM movies")
    Flowable<List<MovieEntity>> getAll();

    //TODO: it is necessary to correct it
//    @Query("SELECT * FROM movie_collections WHERE collection_type = :collectionType")
//    Flowable<List<MovieEntity>> getMovieCollection(MovieCollectionType collectionType);

//    @Query("SELECT * FROM movies WHERE id = :id")
//    Maybe<MovieEntity> getMovieById(int id);
}
