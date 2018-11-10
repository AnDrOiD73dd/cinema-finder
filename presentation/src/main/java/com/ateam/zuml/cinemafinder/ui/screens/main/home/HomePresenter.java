package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.movie.GetPopularMoviesUseCase;
import com.ateam.zuml.cinemafinder.util.CollectionsRow;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import javax.inject.Named;

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
        getViewState().inflateRow(CollectionsRow.POPULAR);
        getViewState().inflateRow(CollectionsRow.NOW_PLAYING);
    }

    public void onBackPressed() {
        router.exit();
    }
}
