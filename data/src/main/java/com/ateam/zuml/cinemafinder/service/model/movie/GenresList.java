package com.ateam.zuml.cinemafinder.service.model.movie;

public final class GenresList {

    private final Genre[] genres;

    public GenresList(Genre[] genres) {
        this.genres = genres;
    }

    public Genre[] getGenres() {
        return genres;
    }
}
