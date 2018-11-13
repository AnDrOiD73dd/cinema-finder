package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import com.arellomobile.mvp.MvpView;

public interface RatingsView extends MvpView {

    void updateFirstRow();

    void updateSecondRow();

    void updateThirdRow();

    void updateFourthRow();

    void showFirstLoading();

    void showSecondLoading();

    void showThirdLoading();

    void showFourthLoading();

    void hideFirstLoading();

    void hideSecondLoading();

    void hideThirdLoading();

    void hideFourthLoading();

    void showNoInFirst();

    void showNoInSecond();

    void showNoInThird();

    void showNoInFourth();

    void showNotifyingMessage(String msg);
}