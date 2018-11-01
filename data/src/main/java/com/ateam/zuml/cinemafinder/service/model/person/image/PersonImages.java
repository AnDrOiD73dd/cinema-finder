package com.ateam.zuml.cinemafinder.service.model.person.image;

import com.google.gson.annotations.SerializedName;

public final class PersonImages {
    @SerializedName("id") private final int peopleId;
    private final Image[] profiles;

    public PersonImages(final int peopleId, final Image[] profiles) {
        this.peopleId = peopleId;
        this.profiles = profiles;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public Image[] getProfiles() {
        return profiles;
    }
}
