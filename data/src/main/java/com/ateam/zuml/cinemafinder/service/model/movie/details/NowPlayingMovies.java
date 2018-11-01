package com.ateam.zuml.cinemafinder.service.model.movie.details;

// Get a list of movies in theatres.
// This is a release type query that looks for all movies
//      that have a release type of 2 or 3 within the specified date range.
public final class NowPlayingMovies {
    private final int page;
    private final int totalPages;
    private final DateRange dates;
    private final MovieCardResult[] results;

    public NowPlayingMovies(final int page, final int totalPages, final DateRange dates,
                            final MovieCardResult[] results) {
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

    public MovieCardResult[] getMovies() {
        return results;
    }
}
