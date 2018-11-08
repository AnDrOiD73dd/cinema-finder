package com.ateam.zuml.cinemafinder.service.model.common.genre;

import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieInfo;

/**
 * Part of {@link GenresList}, {@link MovieInfo}
 */
public final class Genre {
    private final int id;
    private final String name;

    public Genre(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
