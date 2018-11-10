package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.movie.GetPopularMoviesUseCase;
import com.ateam.zuml.cinemafinder.util.CollectionsRow;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router router;

    @Inject GetPopularMoviesUseCase useCase;
    @Inject SchedulersProvider schedulers;

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
        inflateCollections();
    }

    private void inflateCollections() {
        getViewState().inflatePopularRow(CollectionsRow.POPULAR);
    }

    public void onBackPressed() {
        router.exit();
    }
}
