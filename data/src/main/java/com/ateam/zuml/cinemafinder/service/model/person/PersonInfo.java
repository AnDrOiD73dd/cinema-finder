package com.ateam.zuml.cinemafinder.service.model.person;

import android.support.annotation.Nullable;

import com.ateam.zuml.cinemafinder.service.model.person.image.PersonImages;

public final class PersonInfo {
    private final int id;
    @Nullable private final String birthday;
    @Nullable private final String deathday;
    private final String name;
    private final int gender;
    private final String biography;
    @Nullable private final String placeOfBirth;
    @Nullable private final String profilePath;
    @Nullable private final String homepage;
    private final PersonImages images;

    public
    PersonInfo(final int id, @Nullable final String birthday, @Nullable final String deathday,
               final String name, final int gender, final String biography,
               @Nullable final String placeOfBirth, @Nullable final String profilePath,
               @Nullable final String homepage, final PersonImages images) {
        this.id = id;
        this.birthday = birthday;
        this.deathday = deathday;
        this.name = name;
        this.gender = gender;
        this.biography = biography;
        this.placeOfBirth = placeOfBirth;
        this.profilePath = profilePath;
        this.homepage = homepage;
        this.images = images;
    }

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

    public PersonImages getImages() {
        return images;
    }
}
