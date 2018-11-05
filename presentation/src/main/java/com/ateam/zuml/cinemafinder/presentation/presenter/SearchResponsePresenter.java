package com.ateam.zuml.cinemafinder.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.SearchResponseView;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.Const;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SearchResponsePresenter extends MvpPresenter<SearchResponseView> {

    @Named(Const.MAIN_CONTAINER) @Inject Router router;

    public void showDetailsInfo() {
        getViewState().closeSearch();
        router.navigateTo(new Screens.DetailMovieScreen());
    }
}
