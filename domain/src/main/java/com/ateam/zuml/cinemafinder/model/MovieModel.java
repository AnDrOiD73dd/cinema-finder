package com.ateam.zuml.cinemafinder.model;

import io.reactivex.annotations.Nullable;

public final class MovieModel {

    private final String id;
    private final String title;
    private final String originalTitle;
    private final String releaseDate;
    private final String[] genres;
    private final String voteAverage;
    private final String posterPath;

    public MovieModel(final String id, final String title, final String originalTitle,
                      final String releaseDate, final String[] genres, final String voteAverage,
                      final String posterPath) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.voteAverage = voteAverage;
        this.posterPath = posterPath;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Nullable
    public String getReleaseYear() {
        return getPartOfReleaseDate(0);
    }

    @Nullable
    public String getReleaseMonth() {
        return getPartOfReleaseDate(1);
    }

    @Nullable
    public String getReleaseDay() {
        return getPartOfReleaseDate(2);
    }

    public String[] getGenres() {
        return genres;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    private String getPartOfReleaseDate(int part) {
        try {
            return releaseDate.split("-")[part];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}
