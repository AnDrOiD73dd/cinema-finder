package com.ateam.zuml.cinemafinder.database.room.model.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.ateam.zuml.cinemafinder.database.room.ListConverter;

import java.util.List;

@Entity(tableName = "movies")
@TypeConverters(ListConverter.class)
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
    private final String voteAverage;
    private final List<String> genres;
    private final boolean isAdult;

    public MovieEntity(final int id, final String title, final String originalTitle,
                       final String posterPath, final String releaseDate, final String voteAverage,
                       final List<String> genres, final boolean isAdult) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.genres = genres;
        this.isAdult = isAdult;
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

    public String getVoteAverage() {
        return voteAverage;
    }

    public List<String> getGenres() {
        return genres;
    }

    public boolean isAdult() {
        return isAdult;
    }
}
