package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

public class PersonImages {
    @SerializedName("id")
    private int peopleId;
    private Image[] profiles;

    public int getPeopleId() {
        return peopleId;
    }

    public Image[] getProfiles() {
        return profiles;
    }
}
