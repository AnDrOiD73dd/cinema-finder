package com.ateam.zuml.cinemafinder.ui.common.collection;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.movie.GetNowPlayingMoviesUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.GetUpcomingMoviesUseCase;
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

import io.reactivex.Single;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class CollectionRowPresenter extends MvpPresenter<CollectionRowView> {

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    @Inject GetUpcomingMoviesUseCase useCasePopular;
    @Inject GetNowPlayingMoviesUseCase useCaseNowPlaying;
    @Inject GetUpcomingMoviesUseCase useCaseUpcoming;
    @Inject SchedulersProvider schedulers;
    @Inject Logger logger;

    private CollectionsRow collection;
    private RowListPresenter listPresenter;

    CollectionRowPresenter(CollectionsRow collection) {
        this.collection = collection;
        this.listPresenter = new RowListPresenter();
    }

    @Override
    public void attachView(CollectionRowView view) {
        super.attachView(view);
        loadData();
    }

    private void loadData() {
        logger.d("");
        getViewState().showLoading();
        switch (collection) {
            case POPULAR:
                getCollection(useCasePopular.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300));
                break;
            case NOW_PLAYING:
                getCollection(useCaseNowPlaying.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300));
                break;
            case UPCOMING:
                getCollection(useCaseUpcoming.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300));
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void getCollection(Single<List<MovieListModel>> data) {
        data.observeOn(schedulers.ui())
                .subscribe(this::onLoadSuccess, throwable -> onLoadFailed());
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

        void bindViewAt(CollectionRowCardView view, int position) {
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