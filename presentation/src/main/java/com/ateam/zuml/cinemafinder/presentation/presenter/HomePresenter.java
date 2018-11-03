package com.ateam.zuml.cinemafinder.presentation.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.view.HomeView;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.Const;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {

    @Named(Const.CHILD_CONTAINER) @Inject Router router;

    public boolean showFragment(int itemId) {
        switch (itemId) {
            case R.id.action_trends:
                router.replaceScreen(new Screens.TrendsScreen());
                return true;
            case R.id.action_favorites:
                router.replaceScreen(new Screens.FavoritesScreen());
                return true;
            case R.id.action_ratings:
                router.replaceScreen(new Screens.RatingsScreen());
                return true;
            default:
                return false;
        }
    }
}
