package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Cast {
    int castId;
    String character;
    String creditId;
    int gender;
    @SerializedName("id")
    int peopleId;
    String name;
    int order;
    @Nullable String profilePath;
}
