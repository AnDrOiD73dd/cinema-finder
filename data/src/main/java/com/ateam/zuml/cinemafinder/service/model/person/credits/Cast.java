package com.ateam.zuml.cinemafinder.service.model.person.credits;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

// Part of other objects: Credits

public  final class Cast {
    private final int castId;
    private final String character;
    private final String creditId;
    private final int gender;
    @SerializedName("id") private final int peopleId;
    private final String name;
    private final int order;
    @Nullable private final String profilePath;

    public Cast(final int castId, final String character, final String creditId, final int gender,
                final int peopleId, final String name, final int order, @Nullable final String profilePath) {
        this.castId = castId;
        this.character = character;
        this.creditId = creditId;
        this.gender = gender;
        this.peopleId = peopleId;
        this.name = name;
        this.order = order;
        this.profilePath = profilePath;
    }

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
