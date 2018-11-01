package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

// Part of other objects
public class VideoSet {
    @SerializedName("id")
    private int movieId; // Movie id
    private Video[] results;

    public int getMovieId() {
        return movieId;
    }

    public Video[] getResults() {
        return results;
    }
}
