package com.ateam.zuml.cinemafinder.ui.common.collection;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.movie.GetPopularMoviesUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.CollectionsRow;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.Logger;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class CollectionRowPresenter extends MvpPresenter<CollectionRowView> {

    private CollectionsRow collection;
    private RowListPresenter listPresenter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    @Inject GetPopularMoviesUseCase useCase;
    @Inject SchedulersProvider schedulers;
    @Inject Logger logger;

    CollectionRowPresenter(CollectionsRow collection) {
        this.collection = collection;
        this.listPresenter = new RowListPresenter();
    }

    @Override
    public void attachView(CollectionRowView view) {
        super.attachView(view);
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
        logger.d("");
        getViewState().showLoading();
        if (collection == CollectionsRow.POPULAR) {
            useCase.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                    .observeOn(schedulers.ui())
                    .subscribe(this::onLoadSuccess, throwable -> onLoadFailed());
        }
    }

    private void onLoadSuccess(List<MovieListModel> movieListModels) {
        logger.d("");
        getViewState().hideLoading();
        listPresenter.movieList = movieListModels;
        getViewState().updateCollectionRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInCollection();
        }
    }

    private void onLoadFailed() {
        logger.d("");
        getViewState().hideLoading();
        getViewState().showError();
    }

    RowListPresenter getListPresenter() {
        return listPresenter;
    }

    final class RowListPresenter {

        private List<MovieListModel> movieList;

        RowListPresenter() {
            this.movieList = new ArrayList<>();
        }

        void bindViewAt(RowView view, int position) {
            MovieListModel movieListModel = movieList.get(position);
            if (movieListModel.getPosterPath().isEmpty()) {
                view.setPosterPlaceholder();
            } else {
                view.setPoster(movieListModel.getPosterPath());
            }
            view.setTitle(movieListModel.getTitle());
            view.setVoteAverage(movieListModel.getVoteAverage());
            view.setReleaseDate(movieListModel.getReleaseYear());
        }

        int getCollectionItems() {
            return movieList.size();
        }

        void onClickedRowItem(int position) {
            router.navigateTo(new Screens.DetailMovieScreen(listPresenter.movieList.get(position).getId()));
        }
    }
}