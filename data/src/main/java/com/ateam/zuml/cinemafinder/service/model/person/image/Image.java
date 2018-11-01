package com.ateam.zuml.cinemafinder.service.model.person.image;

// Part of other objects: PersonImages

public final class Image {
    private final long aspectRatio;
    private final int width;
    private final int height;
    private final int voteCount;
    private final long voteAverage;
    private final String filePath;

    public Image(final long aspectRatio, final int width, final int height, final int voteCount,
                 final long voteAverage, final String filePath) {
        this.aspectRatio = aspectRatio;
        this.width = width;
        this.height = height;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.filePath = filePath;
    }

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
