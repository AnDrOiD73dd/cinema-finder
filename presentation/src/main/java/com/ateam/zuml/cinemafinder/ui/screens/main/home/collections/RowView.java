package com.ateam.zuml.cinemafinder.ui.screens.main.home.collections;

public interface RowView {
    void setPoster(String posterPath);

    void setPosterPlaceholder();

    void setTitle(String title);

    void setVoteAverage(String voteAverage);
}