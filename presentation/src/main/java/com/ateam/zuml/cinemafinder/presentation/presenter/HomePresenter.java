package com.ateam.zuml.cinemafinder.presentation.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.view.HomeView;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.CiceroneHolder;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {

    private final String containerName;

    @Inject CiceroneHolder ciceroneHolder;

    public HomePresenter(String containerName) {
        this.containerName = containerName;
    }

    private Router getRouter() {
        return ciceroneHolder.getCicerone(containerName).getRouter();
    }

    public boolean showFragment(int itemId) {
        switch (itemId) {
            case R.id.action_trends:
                getRouter().replaceScreen(new Screens.TrendsScreen());
                return true;
            case R.id.action_favorites:
                getRouter().replaceScreen(new Screens.FavoritesScreen());
                return true;
            case R.id.action_ratings:
                getRouter().replaceScreen(new Screens.RatingsScreen());
                return true;
            default:
                return false;
        }
    }
}
