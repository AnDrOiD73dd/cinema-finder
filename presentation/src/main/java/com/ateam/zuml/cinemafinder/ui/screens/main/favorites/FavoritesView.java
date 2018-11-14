package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface FavoritesView extends MvpView {

    void updateItemsList();

    void itemRemoved(int position);

    @StateStrategyType(SkipStrategy.class)
    void showNotifyingMessage(String msg);
}
