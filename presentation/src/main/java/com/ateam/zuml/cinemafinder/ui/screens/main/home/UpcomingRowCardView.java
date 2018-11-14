package com.ateam.zuml.cinemafinder.ui.screens.main.home;

public interface UpcomingRowCardView {

    void setPoster(String posterPath);

    void setTitle(String title);

    void setReleaseDate(String releaseDate);

    void setToggleFavorites(boolean isFavorite);
}