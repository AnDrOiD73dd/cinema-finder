package com.ateam.zuml.cinemafinder.service.model.movie.details;

public final class DateRange {
    private final String minimum;
    private final String maximum;

    public DateRange(final String minimum, final String maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public String getMaximum() {
        return maximum;
    }
}
