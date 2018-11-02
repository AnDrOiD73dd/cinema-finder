package com.ateam.zuml.cinemafinder.service.model.movie.search;

public final class MovieSearchResult {

    private final int page;
    private final int totalResults;
    private final int totalPages;
    private final Results[] results;

    public MovieSearchResult(final int page, final int totalResults, final int totalPages,
                             final Results[] results) {
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

    public Results[] getResults() {
        return results;
    }
}
