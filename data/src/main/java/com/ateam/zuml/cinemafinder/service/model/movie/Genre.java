package com.ateam.zuml.cinemafinder.service.model.movie;

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
