package com.ateam.zuml.cinemafinder.service.model.movie.details;

public final class MovieResult {

    private final int voteCount;
    private final int id;
    private final boolean video;
    private final float voteAverage;
    private final String title;
    private final float popularity;
    private final String posterPath;
    private final String originalLanguage;
    private final String originalTitle;
    private final int[] genreIds;
    private final String backdropPath;
    private final boolean adult;
    private final String overview;
    private final String releaseDate;

    public MovieResult(final int voteCount, final int id, final boolean video, final float voteAverage,
                final String title, final float popularity, final String posterPath,
                final String originalLanguage, final String originalTitle, final int[] genreIds,
                final String backdropPath, final boolean adult, final String overview,
                final String releaseDate) {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
