package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

public interface FavoriteRowView {

    void setPoster(String posterPath);

    void setTitle(String title);

    void setOriginalTitle(String originalTitle);

    void setReleaseDate(String releaseDate);

    void setGenres(String genres);

    void setVoteAverage(String voteAverage);
}
