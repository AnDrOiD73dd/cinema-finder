package com.ateam.zuml.cinemafinder.presentation.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.MainContainerView;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainContainerPresenter extends MvpPresenter<MainContainerView> {

    enum BottomScreens  {
        HOME,
        FAVORITES,
        RATINGS
    }

    private BottomScreens currentScreen;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router localRouter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router globalRouter;


    public void onHomeScreenSelected() {
        if(currentScreen == BottomScreens.HOME) {
            return;
        }
        currentScreen = BottomScreens.HOME;
        localRouter.replaceScreen(new Screens.HomeScreen());
    }

    public void onFavoritesScreenSelected() {
        if(currentScreen == BottomScreens.FAVORITES) {
            return;
        }
        currentScreen = BottomScreens.FAVORITES;
        localRouter.replaceScreen(new Screens.FavoritesScreen());
    }

    public void onRatingsScreenSelected() {
        if(currentScreen == BottomScreens.RATINGS) {
            return;
        }
        currentScreen = BottomScreens.RATINGS;
        localRouter.replaceScreen(new Screens.RatingsScreen());
    }

    public void onBackPressed() {
        globalRouter.exit();
    }
}
