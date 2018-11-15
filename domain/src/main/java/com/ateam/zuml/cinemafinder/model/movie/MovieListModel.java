package com.ateam.zuml.cinemafinder.model.movie;

public final class MovieListModel extends BaseMovieModel {

    public MovieListModel(final String id, final String title, final String originalTitle,
                          final String releaseDate, final String[] genres, final String voteAverage,
                          final String posterPath, final boolean isFavorite, final boolean isAdult) {
        super(id, title, originalTitle, releaseDate, genres, voteAverage, posterPath, isFavorite, isAdult);
    }
}
