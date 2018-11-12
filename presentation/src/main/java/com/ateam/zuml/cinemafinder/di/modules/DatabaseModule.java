package com.ateam.zuml.cinemafinder.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.ateam.zuml.cinemafinder.database.room.MovieDatabase;
import com.ateam.zuml.cinemafinder.database.room.daos.FavoritesDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class DatabaseModule {

    private static final String DB_NAME = "cinema_finder_db";

    @Singleton
    @Provides
    MovieDatabase provideMovieDatabase(final Context context) {
        return Room.databaseBuilder(context, MovieDatabase.class, DB_NAME).build();
    }

    @Singleton
    @Provides
    FavoritesDao provideFavoritesDao(final MovieDatabase database) {
        return database.getFavoritesDao();
    }
}
