package com.ateam.zuml.cinemafinder.service.model.movie;

final class Genre {
    private final Integer id;
    private final String name;

    public Genre(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
