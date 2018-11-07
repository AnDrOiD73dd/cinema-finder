package com.ateam.zuml.cinemafinder.service.model.movie.lists;

import com.ateam.zuml.cinemafinder.service.api.ApiService;

/**
 * Result for {@link ApiService#getSearchMovies(String, String, String, String)},
 * {@link ApiService#getPopularMovies(String, String, String)}.
 */
public final class MoviesList {

    private final int page;
    private final int totalResults;
    private final int totalPages;
    private final MovieResult[] results;

    public MoviesList(final int page, final int totalResults, final int totalPages,
                      final MovieResult[] results) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public MovieResult[] getResults() {
        return results;
    }
}
