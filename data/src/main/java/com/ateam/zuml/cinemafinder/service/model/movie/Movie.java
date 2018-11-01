package com.ateam.zuml.cinemafinder.service.model.movie;

import android.support.annotation.Nullable;

import com.ateam.zuml.cinemafinder.service.model.movie.video.VideoSet;
import com.google.gson.annotations.SerializedName;

//Get the primary information about a movie.
public final class Movie {
    @SerializedName("id") private final int movieId;
    private final int budget;
    private final String title;
    private final boolean adult;
    private final Genre[] genres;
    @Nullable private final String homepage;
    private final String overview;
    private final String posterPath;
    private final String releaseDate;
    private final String status;  //Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled
    private final String tagline;
    private final Country[] countries;
    @Nullable private final Integer runtime;
    private final long voteAverage;
    private final int voteCount;
    private final VideoSet videos;

    public Movie(final int movieId, final int budget, final String title, final boolean adult,
                 final Genre[] genres, @Nullable final String homepage, final String overview,
                 final String posterPath, final String releaseDate, final String status,
                 final String tagline, final Country[] countries, final int runtime,
                 final long voteAverage, final int voteCount, final VideoSet videos) {
        this.movieId = movieId;
        this.budget = budget;
        this.title = title;
        this.adult = adult;
        this.genres = genres;
        this.homepage = homepage;
        this.overview = overview;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.status = status;
        this.tagline = tagline;
        this.countries = countries;
        this.runtime = runtime;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.videos = videos;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getBudget() {
        return budget;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAdult() {
        return adult;
    }

    public Genre[] getGenres() {
        return genres;
    }

    @Nullable
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

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public Country[] getCountries() {
        return countries;
    }

    @Nullable
    public Integer getRuntime() {
        return runtime;
    }

    public long getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public VideoSet getVideos() {
        return videos;
    }
}
