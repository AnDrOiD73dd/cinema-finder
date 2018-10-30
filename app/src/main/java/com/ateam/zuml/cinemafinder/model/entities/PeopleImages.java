package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

public class PeopleImages {
    @SerializedName("id")
    int peopleId;
    ProfileImage[] profiles;
}
