package com.ateam.zuml.cinemafinder.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.ateam.zuml.cinemafinder.enums.RowCollection;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface HomeView extends MvpView {

    void inflateRow(RowCollection collection);
}
