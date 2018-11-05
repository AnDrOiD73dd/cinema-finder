package com.ateam.zuml.cinemafinder.presentation.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.view.MainContainerView;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.Const;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainContainerPresenter extends MvpPresenter<MainContainerView> {

    private int currentPageId;

    @Named(Const.CHILD_CONTAINER) @Inject Router router;

    public boolean showFragment(int itemId) {
        if(currentPageId == itemId) {
            return false;
        }

        switch (itemId) {
            case R.id.action_trends:
                currentPageId = itemId;
                router.replaceScreen(new Screens.TrendsScreen());
                return true;
            case R.id.action_favorites:
                currentPageId = itemId;
                router.replaceScreen(new Screens.FavoritesScreen());
                return true;
            case R.id.action_ratings:
                currentPageId = itemId;
                router.replaceScreen(new Screens.RatingsScreen());
                return true;
            default:
                return false;
        }
    }
}
