package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

// Part of other objects: Credits

class Crew {
    private String creditId;
    private String department;
    @Nullable
    private int gender;
    @SerializedName("id")
    private int peopleId;
    private String job;
    private String name;
    private String profilePath;

    public String getCreditId() {
        return creditId;
    }

    public String getDepartment() {
        return department;
    }

    @Nullable
    public int getGender() {
        return gender;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }

    public String getProfilePath() {
        return profilePath;
    }
}
