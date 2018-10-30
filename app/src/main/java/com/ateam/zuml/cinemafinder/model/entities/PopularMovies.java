package com.ateam.zuml.cinemafinder.model.entities;

//Get a list of the current popular movies on TMDb. This list updates daily.
public class PopularMovies {
    private int page;
    private int totalPages;
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

    public MovieCardResult[] getMovies() {
        return results;
    }
}
