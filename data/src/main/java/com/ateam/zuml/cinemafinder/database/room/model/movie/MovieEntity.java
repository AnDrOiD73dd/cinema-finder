package com.ateam.zuml.cinemafinder.database.room.model.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.database.room.MovieStatusConverter;
import com.ateam.zuml.cinemafinder.enums.MovieStatus;

import java.util.List;

@Entity(tableName = "movies", primaryKeys = "id")
public final class MovieEntity {

    @PrimaryKey
    private int id;

    @NonNull private final String title;

    private final boolean adult;

    @NonNull private final String homepage;

    @NonNull private final String overview;

    @ColumnInfo(name = "poster_path")
    @NonNull
    private final String posterPath;

    @ColumnInfo(name = "release_data")
    @NonNull
    private final String releaseDate;

    @TypeConverters(MovieStatusConverter.class)
    @NonNull
    private final MovieStatus status;  //Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled

    @NonNull private final String tagline;

    private final int runtime;

    @ColumnInfo(name = "vote_average")
    private final long voteAverage;

    @ColumnInfo(name = "vote_count")
    private final int voteCount;

    @Ignore
    @Relation(entity = MovieGenresEntity.class, parentColumn = "id", entityColumn = "movie_id")
    private List<MovieGenresEntity> genres;

    @Ignore
    @Relation(entity = ProductionCountriesEntity.class, parentColumn = "id", entityColumn = "movie_id")
    private List<ProductionCountriesEntity> productionCountries;


    public MovieEntity(@NonNull String title, boolean adult, @NonNull String homepage,
                       @NonNull String overview, @NonNull String posterPath, @NonNull String releaseDate,
                       @NonNull MovieStatus status, @NonNull String tagline, int runtime,
                       long voteAverage, int voteCount) {
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

    public List<MovieGenresEntity> getGenres() {
        return genres;
    }

    public List<ProductionCountriesEntity> getProductionCountries() {
        return productionCountries;
    }
}