package com.ateam.zuml.cinemafinder.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.DetailMovieView;
import com.ateam.zuml.cinemafinder.util.Const;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class DetailMoviePresenter extends MvpPresenter<DetailMovieView> {

    @Named(Const.MAIN_CONTAINER)
    @Inject
    Router router;

    public void onBackPressed() {
        router.exit();
    }
}
