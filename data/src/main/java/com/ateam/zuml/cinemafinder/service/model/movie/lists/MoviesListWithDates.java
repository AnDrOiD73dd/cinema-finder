package com.ateam.zuml.cinemafinder.service.model.movie.lists;

import com.ateam.zuml.cinemafinder.service.api.ApiService;

/**
 * Result for {@link ApiService#getNowPlayingMovies(String, String, String)}
 */
public final class MoviesListWithDates {

    private final int page;
    private final int totalPages;
    private final DateRange dates;
    private final MovieResult[] results;

    public MoviesListWithDates(final int page, final int totalPages, final DateRange dates,
                               final MovieResult[] results) {
        this.page = page;
        this.totalPages = totalPages;
        this.dates = dates;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public DateRange getDates() {
        return dates;
    }

    public MovieResult[] getMovies() {
        return results;
    }
}
