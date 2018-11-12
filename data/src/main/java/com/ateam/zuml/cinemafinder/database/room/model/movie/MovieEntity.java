package com.ateam.zuml.cinemafinder.database.room.model.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "movies")
public final class MovieEntity {

    @PrimaryKey
    private int id;
    private final String title;
    private final String originalTitle;
    @ColumnInfo(name = "poster_path")
    private final String posterPath;
    @ColumnInfo(name = "release_data")
    private final String releaseDate;
    @ColumnInfo(name = "vote_average")
    private final int voteAverage;
    private String[] genres;

    public MovieEntity(final int id, final String title, final String originalTitle,
                       final String posterPath, final String releaseDate, final int voteAverage,
                       final String[] genres) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public String[] getGenres() {
        return genres;
    }
}
