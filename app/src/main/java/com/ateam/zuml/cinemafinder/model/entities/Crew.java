package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

class Crew {
    String creditId;
    String department;
    @Nullable int gender;
    @SerializedName("id")
    int peopleId;
    String job;
    String name;
    String profilePath;
}
