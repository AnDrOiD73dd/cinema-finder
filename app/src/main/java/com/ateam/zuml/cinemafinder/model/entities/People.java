package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

public class People {
    private int id;
    private @Nullable String birthday;
    private @Nullable String deathday;
    private String name;
    private int gender;
    private String biography;
    private @Nullable String placeOfBirth;
    private @Nullable String profilePath;
    private @Nullable String homepage;
    private PeopleImages images;

    public int getId() {
        return id;
    }

    @Nullable
    public String getBirthday() {
        return birthday;
    }

    @Nullable
    public String getDeathday() {
        return deathday;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public String getBiography() {
        return biography;
    }

    @Nullable
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @Nullable
    public String getProfilePath() {
        return profilePath;
    }

    @Nullable
    public String getHomepage() {
        return homepage;
    }

    public PeopleImages getImages() {
        return images;
    }
}
