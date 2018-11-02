package com.ateam.zuml.cinemafinder.database.room.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.database.room.MovieStatusConverter;
import com.ateam.zuml.cinemafinder.enums.MovieStatus;

@Entity(tableName = "movies", primaryKeys = "id")
public final class MovieEntity {

    @PrimaryKey @NonNull
    private final int id;

    @NonNull private final String title;

    private final boolean adult;

    @NonNull private final String homepage;

    @NonNull private final String overview;

    @ColumnInfo(name = "poster_path")
    @NonNull private final String posterPath;

    @ColumnInfo(name = "release_data")
    @NonNull private final String releaseDate;

    @TypeConverters({MovieStatusConverter.class})
    @NonNull private MovieStatus status;  //Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled

    @NonNull private final String tagline;

    private final int runtime;
    @ColumnInfo(name = "vote_average")

    private final long voteAverage;

    @ColumnInfo(name = "vote_count")
    private final int voteCount;

    public MovieEntity(@NonNull int id, String title, boolean adult, String homepage,
                       String overview, String posterPath, String releaseDate, MovieStatus status,
                       String tagline, Integer runtime, long voteAverage, int voteCount) {
        this.id = id;
        this.title = title;
        this.adult = adult;
        this.homepage = homepage;
        this.overview = overview;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.status = status;
        this.tagline = tagline;
        this.runtime = runtime;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public MovieStatus getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public long getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }
}
