package com.ateam.zuml.cinemafinder.service.model.person.credits;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

// Part of other objects: Credits

final class Crew {
    private final String creditId;
    private final String department;
    @Nullable final private Integer gender;
    @SerializedName("id") final private int peopleId;
    private final String job;
    private final String name;
    private final String profilePath;

    public Crew(final String creditId, final String department, final int gender, final int peopleId,
                final String job, final String name, final String profilePath) {
        this.creditId = creditId;
        this.department = department;
        this.gender = gender;
        this.peopleId = peopleId;
        this.job = job;
        this.name = name;
        this.profilePath = profilePath;
    }

    public String getCreditId() {
        return creditId;
    }

    public String getDepartment() {
        return department;
    }

    @Nullable
    public Integer getGender() {
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
