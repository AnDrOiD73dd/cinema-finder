package com.ateam.zuml.cinemafinder.ui.common.collection_row;

public interface CollectionRowCardView {

    void setPoster(String posterPath);

    void setTitle(String title);

    void setVoteAverage(String voteAverage);

    void setReleaseDate(String releaseDate);

    void setToggleFavorites(boolean isFavorite);
}