package com.ateam.zuml.cinemafinder.database.room.model.favorite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "favorites")
public final class FavoriteEntity {

    @PrimaryKey
    private final int id;

    @SerializedName("movie_id")
    private final int movieId;

    public FavoriteEntity(int id, int movieId) {
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
