package com.ateam.zuml.cinemafinder.ui.common.collection;

import com.arellomobile.mvp.MvpView;

public interface CollectionRowView extends MvpView {

    void showError();

    void showLoading();

    void hideLoading();

    void updateCollectionRow();

    void showNoInCollection();

    void hideNoInCollection();
}