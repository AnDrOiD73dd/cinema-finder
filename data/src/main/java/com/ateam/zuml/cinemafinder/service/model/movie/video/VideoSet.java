package com.ateam.zuml.cinemafinder.service.model.movie.video;

import com.google.gson.annotations.SerializedName;

// Part of other objects
public final class VideoSet {
    @SerializedName("id") private final int movieId;
    private final Video[] results;

    public VideoSet(final int movieId, final Video[] results) {
        this.movieId = movieId;
        this.results = results;
    }

    public int getMovieId() {
        return movieId;
    }

    public Video[] getResults() {
        return results;
    }
}
