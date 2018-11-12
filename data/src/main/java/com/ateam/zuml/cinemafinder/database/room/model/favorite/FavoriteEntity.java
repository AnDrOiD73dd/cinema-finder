package com.ateam.zuml.cinemafinder.database.room.model.favorite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "favorites",
        foreignKeys = @ForeignKey(entity = MovieEntity.class, parentColumns = "id",
                childColumns = "movie_id", onDelete = ForeignKey.CASCADE))
public final class FavoriteEntity {

    @PrimaryKey(autoGenerate = true)
    private final int id;

    @SerializedName("movie_id")
    private final int movieId;

    public FavoriteEntity(final int id, final int movieId) {
        this.id = id;
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }
}
