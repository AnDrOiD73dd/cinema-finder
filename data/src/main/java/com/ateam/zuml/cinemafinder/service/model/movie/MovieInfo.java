package com.ateam.zuml.cinemafinder.service.model.movie;

import android.support.annotation.Nullable;

import com.ateam.zuml.cinemafinder.service.model.movie.video.VideoSet;

//Get the primary information about a movie.
public final class MovieInfo {
    private final int id;
    private final String title;
    private final String originalTitle;
    private final int budget;
    private final int revenue;
    private final boolean adult;
    private final Genre[] genres;
    @Nullable private final String homepage;
    private final String overview;
    private final String posterPath;
    private final String releaseDate;
    private final String status;  //Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled
    private final String tagline;
    private final Country[] countries;
    private final int runtime;
    private final float voteAverage;
    private final int voteCount;
    private final VideoSet videos;

    public MovieInfo(final int id, final String title, final String originalTitle, final int budget,
                     int revenue, final boolean adult, final Genre[] genres, @Nullable final String homepage,
                     final String overview, final String posterPath, final String releaseDate,
                     final String status, final String tagline, final Country[] countries,
                     final int runtime, final float voteAverage, final int voteCount, final VideoSet videos) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.budget = budget;
        this.revenue = revenue;
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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int getBudget() {
        return budget;
    }

    public int getRevenue() {
        return revenue;
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

    public int getRuntime() {
        return runtime;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public VideoSet getVideos() {
        return videos;
    }
}
