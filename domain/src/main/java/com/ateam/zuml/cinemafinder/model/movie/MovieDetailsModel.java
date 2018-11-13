package com.ateam.zuml.cinemafinder.model.movie;

public final class MovieDetailsModel extends BaseMovieModel {

    private final String tagline;
    private final String overview;
    private final String runtime;
    private final String budget;
    private final String revenue;
    private final String voteCount;
    private final boolean adult;

    public MovieDetailsModel(final String id, final String title, final String originalTitle,
                             final String releaseDate, final String[] genres, final String voteAverage,
                             final String posterPath, final boolean isFavorite, final String tagline,
                             final String overview, final String runtime, final String budget,
                             final String revenue, final String voteCount, final boolean adult) {
        super(id, title, originalTitle, releaseDate, genres, voteAverage, posterPath, isFavorite);
        this.tagline = tagline;
        this.overview = overview;
        this.runtime = runtime;
        this.budget = budget;
        this.revenue = revenue;
        this.voteCount = voteCount;
        this.adult = adult;
    }

    public String getTagline() {
        return tagline;
    }

    public String getOverview() {
        return overview;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getBudget() {
        return budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public boolean isAdult() {
        return adult;
    }
}
