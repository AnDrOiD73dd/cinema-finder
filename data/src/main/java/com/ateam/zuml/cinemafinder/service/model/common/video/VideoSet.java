package com.ateam.zuml.cinemafinder.service.model.common.video;

import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieInfo;

/**
 * Part of details responses: {@link MovieInfo}
 */
public final class VideoSet {

    private final Video[] results;

    public VideoSet(final Video[] results) {
        this.results = results;
    }

    public Video[] getResults() {
        return results;
    }
}
