package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.util.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class FavoritesPresenter extends MvpPresenter<FavoritesView> {

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router router;

    public void onBackPressed() {
        router.exit();
    }
}
