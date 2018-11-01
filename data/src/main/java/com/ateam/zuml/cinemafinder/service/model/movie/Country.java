package com.ateam.zuml.cinemafinder.service.model.movie;

import com.google.gson.annotations.SerializedName;

// Part of other objects

public final class Country {
    @SerializedName("iso_3166_1") private final String id;
    private final String name;

    public Country(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
