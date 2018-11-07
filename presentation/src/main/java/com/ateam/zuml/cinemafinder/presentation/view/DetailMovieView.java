package com.ateam.zuml.cinemafinder.presentation.view;

import com.arellomobile.mvp.MvpView;

public interface DetailMovieView extends MvpView {

    void showProgressBar();

    void hideProgressBar();

    void showError();

    void setPoster(String imagePath);

    void setTitle(String titleText);

    void setOriginalTitle(String originalTitleText);

    void setReleaseYear(String year);

    void setGenresList(String genresList);

    void setRuntime(String runtime);

    void setVoteAverage(String voteAverage);

    void setVoteCount(String voteCount);

    void setBudget(String budget);

    void setRevenue(String revenue);

    void setReleaseDate(String releaseDate);

    void setTagline(String tagline);

    void showAdult();

    void hideAdult();

    void setOverview(String overview);
}
