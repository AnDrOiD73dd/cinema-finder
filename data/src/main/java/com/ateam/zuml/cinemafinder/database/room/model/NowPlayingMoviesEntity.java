package com.ateam.zuml.cinemafinder.database.room.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

@Entity(tableName = "now_playing_movies",
        foreignKeys = @ForeignKey(entity = MovieEntity.class,
                parentColumns = "id",
                childColumns = "movie_id",
                onDelete = ForeignKey.CASCADE))

public final class NowPlayingMoviesEntity {

    @ColumnInfo(name = "movie_id")
    private final int movieId;

    @ColumnInfo(name = "backdrop_path")
    @NonNull
    private final String backdropPath;

    public NowPlayingMoviesEntity(int movieId, @NonNull String backdropPath) {
        this.movieId = movieId;
        this.backdropPath = backdropPath;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getBackdropPath() {
        return backdropPath;
    }
}
