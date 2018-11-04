package com.ateam.zuml.cinemafinder.database.room;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ateam.zuml.cinemafinder.database.room.daos.MovieDao;
import com.ateam.zuml.cinemafinder.database.room.model.environmet.CountryEntity;
import com.ateam.zuml.cinemafinder.database.room.model.environmet.GenreEntity;
import com.ateam.zuml.cinemafinder.database.room.model.environmet.VideoEntity;
import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieCollectionEntity;
import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;
import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieGenresEntity;
import com.ateam.zuml.cinemafinder.database.room.model.movie.ProductionCountriesEntity;

@Database(entities = {MovieEntity.class, MovieCollectionEntity.class, MovieGenresEntity.class,
                ProductionCountriesEntity.class, CountryEntity.class, GenreEntity.class,
                VideoEntity.class},
        version = 1,
        exportSchema = false)

public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

}