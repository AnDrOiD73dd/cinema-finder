package com.ateam.zuml.cinemafinder.presentation.view;

public interface SearchRowView {

    void setPoster(String posterPath);

    void setPosterPlaceholder();

    void setTitle(String title);

    void setOriginalTitle(String originalTitle);

    void setReleaseDate(String releaseDate);

    void setGenres(String genres);

    void setVoteAverage(String voteAverage);
}
