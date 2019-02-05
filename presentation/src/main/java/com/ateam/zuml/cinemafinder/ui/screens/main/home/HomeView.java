package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface HomeView extends MvpView {

    void updateNowPlayingRow();

    void updateUpcomingRow();

    void showNowPlayingLoading();

    void hideNowPlayingLoading();

    void showUpcomingLoading();

    void hideUpcomingLoading();

    void showNoInNowPlaying();

    void showNoInUpcoming();

    void finishSwipeGestureAction();

    @StateStrategyType(SkipStrategy.class)
    void showNotifyingMessage(String msg);
}
