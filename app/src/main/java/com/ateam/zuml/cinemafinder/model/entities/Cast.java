package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

// Part of other objects: Credits

public class Cast {
    private int castId;
    private String character;
    private String creditId;
    private int gender;
    @SerializedName("id")
    private int peopleId;
    private String name;
    private int order;
    @Nullable
    private String profilePath;

    public int getCastId() {
        return castId;
    }

    public String getCharacter() {
        return character;
    }

    public String getCreditId() {
        return creditId;
    }

    public int getGender() {
        return gender;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    @Nullable
    public String getProfilePath() {
        return profilePath;
    }
}
