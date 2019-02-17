package com.ateam.zuml.cinemafinder.ui.screens.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainContainerPresenter extends MvpPresenter<MainContainerView> {

    private enum BottomScreens {
        HOME,
        FAVORITES,
        RATINGS
    }

    private BottomScreens currentScreen;

    private final Router localRouter;
    private final Router globalRouter;

    @Inject
    MainContainerPresenter(@Named(Constants.CHILD_CONTAINER) Router localRouter,
                           @Named(Constants.MAIN_CONTAINER) Router globalRouter) {
        this.localRouter = localRouter;
        this.globalRouter = globalRouter;
    }

    void onHomeScreenSelected() {
        if (currentScreen == BottomScreens.HOME) {
            return;
        }
        currentScreen = BottomScreens.HOME;
        localRouter.replaceScreen(new Screens.HomeScreen());
    }

    void onFavoritesScreenSelected() {
        if (currentScreen == BottomScreens.FAVORITES) {
            return;
        }
        currentScreen = BottomScreens.FAVORITES;
        localRouter.replaceScreen(new Screens.FavoritesScreen());
    }

    void onRatingsScreenSelected() {
        if (currentScreen == BottomScreens.RATINGS) {
            return;
        }
        currentScreen = BottomScreens.RATINGS;
        localRouter.replaceScreen(new Screens.RatingsScreen());
    }

    public void onBackPressed() {
        globalRouter.exit();
    }
}
