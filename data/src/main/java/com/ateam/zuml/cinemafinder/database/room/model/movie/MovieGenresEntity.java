package com.ateam.zuml.cinemafinder.database.room.model.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.ateam.zuml.cinemafinder.database.room.model.environmet.GenreEntity;

@Entity(tableName = "movie_by_genres",
        indices = @Index(value = {"movie_id"}),
        primaryKeys = {"genre_id", "movie_id"},
        foreignKeys = {@ForeignKey(entity = MovieEntity.class,
                            parentColumns = "id",
                            childColumns = "movie_id",
                            onDelete = ForeignKey.CASCADE),
                        @ForeignKey(entity = GenreEntity.class,
                            parentColumns = "id",
                            childColumns = "genre_id",
                            onDelete = ForeignKey.CASCADE)})
public final class MovieGenresEntity {

    @ColumnInfo(name = "genre_id")
    private final int genreId;

    @ColumnInfo(name = "movie_id")
    private final int movieId;

    public MovieGenresEntity(int genreId, int movieId) {
        this.genreId = genreId;
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public int getMovieId() {
        return movieId;
    }
}
