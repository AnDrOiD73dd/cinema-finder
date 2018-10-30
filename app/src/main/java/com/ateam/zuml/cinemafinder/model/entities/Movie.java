package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

//Get the primary information about a movie.
public class Movie {
    @SerializedName("id")
    private int movieId;
    int budget;
    private String title;
    private boolean adult;
    private Genre[] genres;
    @Nullable private String homepage;
    private String overview;
    private String posterPath;
    private String releaseDate;
    private String status;  //Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled
    private String tagline;
    private Country[] countries;
    @Nullable private int runtime;
    private long voteAverage;
    private int voteCount;
    private VideoSet videos;

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
    public int getRuntime() {
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
