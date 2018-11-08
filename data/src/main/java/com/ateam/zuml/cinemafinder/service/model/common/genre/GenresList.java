package com.ateam.zuml.cinemafinder.service.model.common.genre;

import com.ateam.zuml.cinemafinder.service.api.ApiService;

/**
 * Response to {@link ApiService#getGenres(String)}
 */
public final class GenresList {

    private final Genre[] genres;

    public GenresList(final Genre[] genres) {
        this.genres = genres;
    }

    public Genre[] getGenres() {
        return genres;
    }
}
