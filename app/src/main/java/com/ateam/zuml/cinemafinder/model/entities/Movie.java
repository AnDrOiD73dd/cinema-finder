package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    int movieId;
    boolean adult;
    String title;
    int budget;
    Genre[] genres;
    @Nullable String homepage;
    String overview;
    String posterPath;
    String releaseDate;
    String status;  //Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled
    String tagline;
    Country[] countries;
    @Nullable int runtime;
    long voteAverage;
    int voteCount;
}
