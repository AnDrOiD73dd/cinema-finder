package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

public interface RatingsRowCardView {

    void setPoster(String posterPath);

    void setTitle(String title);

    void setRankingPosition(String rankingPosition);

    void setReleaseDate(String releaseDate);

    void setToggleFavorites(boolean isFavorite);
}