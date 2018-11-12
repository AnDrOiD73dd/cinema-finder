package com.ateam.zuml.cinemafinder.di.application.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.ateam.zuml.cinemafinder.database.room.MovieDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    public MovieDatabase provideMovieDatabase(Context context) {
        return Room.databaseBuilder(context, MovieDatabase.class, "movie_db").build();
    }
}
