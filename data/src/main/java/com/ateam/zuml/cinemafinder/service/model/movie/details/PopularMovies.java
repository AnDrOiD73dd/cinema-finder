package com.ateam.zuml.cinemafinder.service.model.movie.details;

//Get a list of the current popular movies on TMDb. This list updates daily.
public final class PopularMovies {
    private final int page;
    private final int totalPages;
    private final MovieCardResult[] results;

    public PopularMovies(final int page, final int totalPages, final MovieCardResult[] results) {
        this.page = page;
        this.totalPages = totalPages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public MovieCardResult[] getMovies() {
        return results;
    }
}