package com.ateam.zuml.cinemafinder.service.model.movie.details;

import com.google.gson.annotations.SerializedName;

/**
 * Part of {@link MovieInfo}
 */
public final class ProductionCountry {
    @SerializedName("iso_3166_1") private final String id;
    private final String name;

    public ProductionCountry(final String id, final String name) {
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
