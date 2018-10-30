package com.ateam.zuml.cinemafinder.model.entities;

// Part of other objects: PeopleImages

public class Image {
    private long aspectRatio;
    private int width;
    private int height;
    private int voteCount;
    private long voteAverage;
    private String filePath;

    public long getAspectRatio() {
        return aspectRatio;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public long getVoteAverage() {
        return voteAverage;
    }

    public String getFilePath() {
        return filePath;
    }
}
