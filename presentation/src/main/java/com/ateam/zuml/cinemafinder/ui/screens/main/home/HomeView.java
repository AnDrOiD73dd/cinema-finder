package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import com.arellomobile.mvp.MvpView;

public interface HomeView extends MvpView {

    void updateNowPlayingRow();

    void updateUpcomingRow();

    void showNowPlayingLoading();

    void hideNowPlayingLoading();

    void showUpcomingLoading();

    void hideUpcomingLoading();

    void showNoInNowPlaying();

    void showNoInUpcoming();

    void showNotifyingMessage(String msg);
}
