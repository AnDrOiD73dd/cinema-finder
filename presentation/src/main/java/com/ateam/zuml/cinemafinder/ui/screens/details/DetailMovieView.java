package com.ateam.zuml.cinemafinder.ui.screens.details;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface DetailMovieView extends MvpView {

    void showLoading();

    void hideLoading();

    @StateStrategyType(SkipStrategy.class)
    void showNotifyingMessage(String msg);

    void setToggleFavorites(boolean isFavorite);

    void setPoster(String imagePath);

    void setTitle(String titleText);

    void setSubTitle(String subTitleText);

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
