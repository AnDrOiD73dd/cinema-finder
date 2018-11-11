package com.ateam.zuml.cinemafinder.database.room.model.environmet;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "favorites")
public class FavoriteEntity {

    @PrimaryKey
    private final int id;

    @SerializedName("movie_id")
    @NonNull private final int movieId;

    public FavoriteEntity(int id, @NonNull int movieId) {
        this.id = id;
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public int getMovieId() {
        return movieId;
    }
}
