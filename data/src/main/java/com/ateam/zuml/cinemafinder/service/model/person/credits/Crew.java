package com.ateam.zuml.cinemafinder.service.model.person.credits;

/**
 * Part of the {@link Credits}
 */
final class Crew {

    final private int id;
    private final String creditId;
    private final String department;
    final private Integer gender;
    private final String job;
    private final String name;
    private final String profilePath;

    public Crew(final String creditId, final String department, final int gender, final int id,
                final String job, final String name, final String profilePath) {
        this.creditId = creditId;
        this.department = department;
        this.gender = gender;
        this.id = id;
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

    public Integer getGender() {
        return gender;
    }

    public int getId() {
        return id;
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
