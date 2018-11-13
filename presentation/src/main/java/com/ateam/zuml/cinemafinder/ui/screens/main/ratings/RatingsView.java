package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import com.arellomobile.mvp.MvpView;

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

    void showNotifyingMessage(String msg);
}