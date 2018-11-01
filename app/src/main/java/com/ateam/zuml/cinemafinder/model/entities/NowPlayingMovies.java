package com.ateam.zuml.cinemafinder.model.entities;

// Get a list of movies in theatres.
// This is a release type query that looks for all movies
//      that have a release type of 2 or 3 within the specified date range.
public class NowPlayingMovies {
    private int page;
    private int totalPages;
    private DateRange dates;
    private MovieCardResult[] results;

    private class DateRange {
        String minimum;
        String maximum;
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
