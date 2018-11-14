package com.ateam.zuml.cinemafinder.ui.screens.search;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SearchResponseView extends MvpView {

    void closeSearch();

    void updateSearchList();

    void showNoSearchResults();

    void hideNoSearchResults();

    void showError();

    void showLoading();

    void hideLoading();

    @StateStrategyType(SkipStrategy.class)
    void showNotifyingMessage(String msg);
}
