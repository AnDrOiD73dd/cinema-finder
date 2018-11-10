package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import com.arellomobile.mvp.MvpView;
import com.ateam.zuml.cinemafinder.util.CollectionsRow;

public interface HomeView extends MvpView {
    void inflatePopularRow(CollectionsRow collection);
}
