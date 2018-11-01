package com.ateam.zuml.cinemafinder.service.model.person.credits;

import com.google.gson.annotations.SerializedName;

// Get the cast and crew for a movie.
public final class Credits {
    @SerializedName("id") private final int movieId;
    private final Cast[] cast;
    private final Crew[] crew;

    public Credits(final int movieId, final Cast[] cast, final Crew[] crew) {
        this.movieId = movieId;
        this.cast = cast;
        this.crew = crew;
    }

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
