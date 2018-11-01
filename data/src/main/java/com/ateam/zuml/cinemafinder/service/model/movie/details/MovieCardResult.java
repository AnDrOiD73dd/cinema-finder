package com.ateam.zuml.cinemafinder.service.model.movie.details;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

// Part of other objects: PopularMovies, NowPlayingMovies

public final class MovieCardResult {
    @SerializedName("id") private final int movieId;
    @Nullable private final String backdropPath;  //shot from a film
    private final boolean video;
    private final int[] genreIds;
    private final boolean adult;

    public MovieCardResult(final int movieId, @Nullable final String backdropPath,
                           final boolean video, final int[] genreIds, final boolean adult) {
        this.movieId = movieId;
        this.backdropPath = backdropPath;
        this.video = video;
        this.genreIds = genreIds;
        this.adult = adult;
    }

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
