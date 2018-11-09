package com.ateam.zuml.cinemafinder.ui.screens.search;

import com.arellomobile.mvp.MvpView;

public interface SearchResponseView extends MvpView {

    void closeSearch();

    void updateSearchList();

    void showNoSearchResults();

    void hideNoSearchResults();

    void showError();

    void showLoading();

    void hideLoading();
}
