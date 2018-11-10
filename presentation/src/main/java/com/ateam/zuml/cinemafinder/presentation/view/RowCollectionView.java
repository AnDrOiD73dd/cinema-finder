package com.ateam.zuml.cinemafinder.presentation.view;

import com.arellomobile.mvp.MvpView;

public interface RowCollectionView extends MvpView {

    void showError();

    void showLoading();

    void hideLoading();

    void updateCollectionRow();

    void showNoInCollection();

    void hideNoInCollection();
}
