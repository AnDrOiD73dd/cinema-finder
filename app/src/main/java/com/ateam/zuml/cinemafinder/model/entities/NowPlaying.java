package com.ateam.zuml.cinemafinder.model.entities;

public class NowPlaying {
    int page;
    int totalPages;
    DateRange dates;
    MovieCardResult results;

    class DateRange {
        String minimum;
        String maximum;
    }
}
