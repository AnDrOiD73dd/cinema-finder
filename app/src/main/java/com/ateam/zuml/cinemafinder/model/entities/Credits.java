package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

// Get the cast and crew for a movie.
public class Credits {
    @SerializedName("id")
    private int movieId;
    private Cast[] cast;
    private Crew[] crew;

    public int getMovieId() {
        return movieId;
    }

    public Cast[] getCast() {
        return cast;
    }

    public Crew[] getCrew() {
        return crew;
    }
}
