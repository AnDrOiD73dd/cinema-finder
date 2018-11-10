package com.ateam.zuml.cinemafinder.ui.screens.main.home.collections;

import com.arellomobile.mvp.MvpView;

public interface RowCollectionView extends MvpView {
    void showError();

    void showLoading();

    void hideLoading();

    void updateCollectionRow();

    void showNoInCollection();

    void hideNoInCollection();
}