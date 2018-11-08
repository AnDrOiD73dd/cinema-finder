package com.ateam.zuml.cinemafinder.presentation.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.view.MainContainerView;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainContainerPresenter extends MvpPresenter<MainContainerView> {

    private int currentScreenId;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router localRouter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router globalRouter;

    public boolean showFragment(int itemId) {
        if(currentScreenId == itemId) {
            return false;
        }

        switch (itemId) {
            case R.id.action_home:
                currentScreenId = itemId;
                localRouter.replaceScreen(new Screens.HomeScreen());
                return true;
            case R.id.action_favorites:
                currentScreenId = itemId;
                localRouter.replaceScreen(new Screens.FavoritesScreen());
                return true;
            case R.id.action_ratings:
                currentScreenId = itemId;
                localRouter.replaceScreen(new Screens.RatingsScreen());
                return true;
            default:
                return false;
        }
    }

    public void onBackPressed() {
        globalRouter.exit();
    }
}
