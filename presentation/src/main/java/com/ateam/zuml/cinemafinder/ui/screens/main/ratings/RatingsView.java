package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface RatingsView extends MvpView {

    void updateTopMoviesRow();

    void updateTopActionsRow();

    void updateTopComediesRow();

    void updateTopAnimationsRow();

    void showTopMoviesLoading();

    void showTopActionsLoading();

    void showTopComediesLoading();

    void showTopAnimationsLoading();

    void hideTopMoviesLoading();

    void hideTopActionsLoading();

    void hideTopComediesLoading();

    void hideTopAnimationsLoading();

    void showNoInTopMovies();

    void showNoInTopActions();

    void showNoInTopComedies();

    void showNoInTopAnimations();

    @StateStrategyType(SkipStrategy.class)
    void showNotifyingMessage(String msg);
}