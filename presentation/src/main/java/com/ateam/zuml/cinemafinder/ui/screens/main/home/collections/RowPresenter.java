package com.ateam.zuml.cinemafinder.ui.screens.main.home.collections;

import android.annotation.SuppressLint;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.enums.RowCollection;
import com.ateam.zuml.cinemafinder.interactor.movie.GetPopularMoviesUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class RowPresenter extends MvpPresenter<RowCollectionView> {
    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;
    @Inject GetPopularMoviesUseCase useCase;
    @Inject SchedulersProvider schedulers;
    private RowCollection collection;
    private RowListPresenter listPresenter;

    public RowPresenter(RowCollection collection) {
        this.collection = collection;
        this.listPresenter = new RowListPresenter();
    }

    @Override
    public void attachView(RowCollectionView view) {
        super.attachView(view);
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
        getViewState().showLoading();
        if (collection == RowCollection.POPULAR) {
            useCase.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                    .observeOn(schedulers.ui())
                    .subscribe(this::onLoadSuccess, throwable -> onLoadFailed());
        }
    }

    private void onLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideLoading();
        listPresenter.movieList = movieListModels;
        getViewState().updateCollectionRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInCollection();
        }
    }

    private void onLoadFailed() {
        getViewState().hideLoading();
        getViewState().showError();
    }

    public RowListPresenter getListPresenter() {
        return listPresenter;
    }

    public final class RowListPresenter {
        private List<MovieListModel> movieList;

        public RowListPresenter() {
            this.movieList = new ArrayList<>();
        }

        public void bindViewAt(RowView view, int position) {
            MovieListModel movieListModel = movieList.get(position);
            if (movieListModel.getPosterPath().isEmpty()) {
                view.setPosterPlaceholder();
            } else {
                view.setPoster(movieListModel.getPosterPath());
            }
            view.setTitle(movieListModel.getTitle());
            view.setVoteAverage(movieListModel.getVoteAverage());
        }

        public int getCollectionItems() {
            return movieList.size();
        }

        public void showDetailsInfo(int position) {
            router.navigateTo(new Screens.DetailMovieScreen(listPresenter.movieList.get(position).getId()));
        }
    }
}