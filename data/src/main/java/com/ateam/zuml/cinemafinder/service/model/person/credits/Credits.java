package com.ateam.zuml.cinemafinder.service.model.person.credits;

import com.ateam.zuml.cinemafinder.service.api.ApiService;

/**
 * Response to {@link ApiService#getMovieCredits(int)}
 */
public final class Credits {

    private final int id;
    private final Cast[] cast;
    private final Crew[] crew;

    public Credits(final int id, final Cast[] cast, final Crew[] crew) {
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public int getId() {
        return id;
    }

    public Cast[] getCast() {
        return cast;
    }

    public Crew[] getCrew() {
        return crew;
    }
}
