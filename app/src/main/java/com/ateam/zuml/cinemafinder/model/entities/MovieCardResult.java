package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

// Part of other objects: PopularMovies, NowPlayingMovies

public class MovieCardResult {
    @SerializedName("id")
    private int movieId;
    @Nullable
    private String backdropPath;  //кадр из фильма
    private boolean video;
    private int[] genreIds;
    private boolean adult;

    public int getMovieId() {
        return movieId;
    }

    @Nullable
    public String getBackdropPath() {
        return backdropPath;
    }

    public boolean isVideo() {
        return video;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public boolean isAdult() {
        return adult;
    }

}
