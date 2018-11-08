package com.ateam.zuml.cinemafinder.service.model.person.credits;

import android.support.annotation.Nullable;

/**
 * Part of the {@link Credits}
 */
public final class Cast {

    private final int id;
    private final int castId;
    private final String character;
    private final String creditId;
    private final int gender;
    private final String name;
    private final int order;
    private final String profilePath;

    public Cast(final int castId, final String character, final String creditId, final int gender,
                final int id, final String name, final int order, @Nullable final String profilePath) {
        this.castId = castId;
        this.character = character;
        this.creditId = creditId;
        this.gender = gender;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public String getProfilePath() {
        return profilePath;
    }
}
