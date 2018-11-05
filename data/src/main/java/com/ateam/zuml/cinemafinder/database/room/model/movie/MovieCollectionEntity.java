package com.ateam.zuml.cinemafinder.database.room.model.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

@Entity(tableName = "movie_collections",
        primaryKeys = {"movie_id", "collection_type"},
        indices = {@Index(value = {"movie_id", "collection_type"})},
        foreignKeys = @ForeignKey(entity = MovieEntity.class,
                parentColumns = "id",
                childColumns = "movie_id",
                onDelete = ForeignKey.CASCADE))

public final class MovieCollectionEntity {
    @ColumnInfo(name = "movie_id")
    private final int movieId;

    @ColumnInfo(name = "backdrop_path")
    @NonNull
    private final String backdropPath;

    @ColumnInfo(name = "collection_type")
    @NonNull
    private final MovieCollectionEntity collectionType;


    public MovieCollectionEntity(int movieId,
                                 @NonNull String backdropPath,
                                 @NonNull MovieCollectionEntity collectionType) {
        this.movieId = movieId;
        this.backdropPath = backdropPath;
        this.collectionType = collectionType;
    }

    public int getMovieId() {
        return movieId;
    }

    @NonNull
    public String getBackdropPath() {
        return backdropPath;
    }

    @NonNull
    public MovieCollectionEntity getCollectionType() {
        return collectionType;
    }
}
