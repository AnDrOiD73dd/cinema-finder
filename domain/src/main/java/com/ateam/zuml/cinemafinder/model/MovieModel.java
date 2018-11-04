package com.ateam.zuml.cinemafinder.model;

public final class MovieModel {

    private final int id;
    private final String title;
    private final String releaseDate;
    private final String[] genres;
    private final float voteAverage;

    public MovieModel(final int id, final String title, final String releaseDate,
                      final String[] genres, final float voteAverage) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.voteAverage = voteAverage;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String[] getGenres() {
        return genres;
    }

    public float getVoteAverage() {
        return voteAverage;
    }
}
