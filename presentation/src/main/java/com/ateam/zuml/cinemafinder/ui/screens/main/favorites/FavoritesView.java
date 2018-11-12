package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import com.arellomobile.mvp.MvpView;

public interface FavoritesView extends MvpView {

    void updateItemsList();

    void itemRemoved(int position);

    void showNotifyingMessage(String msg);
}
