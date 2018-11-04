package com.ateam.zuml.cinemafinder.service.model.movie.details;

import android.support.annotation.Nullable;

// Part of other objects: PopularMovies, NowPlayingMovies

public final class MovieCardResult {
    private final int id;
    private final String title;
    private final String originalTitle;
    private final String originalLanguage;
    private final String releaseDate;
    private final int[] genreIds;
    private final boolean video;
    private final boolean adult;
    @Nullable private final String backdropPath;  //shot from a film
    @Nullable private final String posterPath;
    private final String overview;
    private final int popularity;
    private final int voteCount;
    private final int voteAverage;

    public MovieCardResult(final int id, final String title, final String originalTitle,
                           final String originalLanguage, final String releaseDate,
                           @Nullable final String backdropPath, final boolean video,
                           final int[] genreIds, final boolean adult, @Nullable String posterPath,
                           final String overview, final int popularity, final int voteCount,
                           final int voteAverage) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.releaseDate = releaseDate;
        this.backdropPath = backdropPath;
        this.video = video;
        this.genreIds = genreIds;
        this.adult = adult;
        this.posterPath = posterPath;
        this.overview = overview;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public boolean isVideo() {
        return video;
    }

    public boolean isAdult() {
        return adult;
    }

    @Nullable public String getBackdropPath() {
        return backdropPath;
    }

    @Nullable public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getVoteAverage() {
        return voteAverage;
    }
}
