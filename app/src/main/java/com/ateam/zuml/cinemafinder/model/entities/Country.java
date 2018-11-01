package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

// Part of other objects

public class Country {
    @SerializedName("iso_3166_1")
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
