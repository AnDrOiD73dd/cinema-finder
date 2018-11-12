package com.ateam.zuml.cinemafinder.database.room.model.favorite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "favorites",
        indices = @Index(value = {"movieId"}),
        foreignKeys = @ForeignKey(entity = MovieEntity.class, parentColumns = "id",
                childColumns = "movieId", onDelete = ForeignKey.CASCADE))
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
