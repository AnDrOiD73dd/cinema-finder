package com.ateam.zuml.cinemafinder.service.model.movie.details;

import android.support.annotation.Nullable;

import com.ateam.zuml.cinemafinder.service.api.ApiService;
import com.ateam.zuml.cinemafinder.service.model.common.video.VideoSet;
import com.ateam.zuml.cinemafinder.service.model.common.genre.Genre;

/**
 * Result for {@link ApiService#getMovieInfo(String, String, String)}
 */
public final class MovieInfo {

    private final int id;
    private final String title;
    private final String originalTitle;
    private final long budget;
    private final long revenue;
    private final boolean adult;
    private final Genre[] genres;
    private final String homepage;
    private final String overview;
    private final String posterPath;
    private final String releaseDate;
    private final String status;
    private final String tagline;
    private final ProductionCountry[] productionCountries;
    private final int runtime;
    private final float voteAverage;
    private final int voteCount;
    private final VideoSet videos;

    public MovieInfo(final int id, final String title, final String originalTitle, final int budget,
                     int revenue, final boolean adult, final Genre[] genres, final String homepage,
                     final String overview, final String posterPath, final String releaseDate,
                     final String status, final String tagline,
                     final ProductionCountry[] productionCountries, final int runtime,
                     final float voteAverage, final int voteCount, final VideoSet videos) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.budget = budget;
        this.revenue = revenue;
        this.adult = adult;
        this.genres = genres;
        this.homepage = homepage;
        this.overview = overview;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.status = status;
        this.tagline = tagline;
        this.productionCountries = productionCountries;
        this.runtime = runtime;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.videos = videos;
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

    public long getBudget() {
        return budget;
    }

    public long getRevenue() {
        return revenue;
    }

    public boolean isAdult() {
        return adult;
    }

    public Genre[] getGenres() {
        return genres;
    }

    @Nullable
    public String getHomepage() {
        return homepage;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @return Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled
     */
    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public ProductionCountry[] getProductionCountries() {
        return productionCountries;
    }

    public int getRuntime() {
        return runtime;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public VideoSet getVideos() {
        return videos;
    }
}
