package com.ateam.zuml.cinemafinder.ui.screens.main.home;

public interface NowPlayingRowCardView {

    void setPoster(String posterPath);

    void setTitle(String title);

    void setVoteAverage(String voteAverage);

    void setReleaseDate(String releaseDate);

    void setToggleFavorites(boolean isFavorite);
}