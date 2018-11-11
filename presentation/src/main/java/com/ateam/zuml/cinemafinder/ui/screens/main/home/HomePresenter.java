package com.ateam.zuml.cinemafinder.ui.screens.main.home;

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
import com.ateam.zuml.cinemafinder.ui.common.collection.CollectionRowCardView;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.Logger;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {

    private RowListPresenter listPresenter;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router router;

    @Inject GetNowPlayingMoviesUseCase useCaseNowPlaying;
    @Inject GetUpcomingMoviesUseCase useCaseUpcoming;
    @Inject SchedulersProvider schedulers;
    @Inject Logger logger;

    public HomePresenter() {
        this.listPresenter = new RowListPresenter();
    }

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadNowPlayingData();
        loadUpcomingData();
    }

    @SuppressLint("CheckResult")
    private void loadNowPlayingData() {
        logger.d("");
        useCaseNowPlaying
                .execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onNowPlayingLoadSuccess, throwable -> onNowPlayingLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadUpcomingData() {
        logger.d("");
        useCaseUpcoming
                .execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onUpcomingLoadSuccess, throwable -> onUpcomingLoadFailed());
    }

    private void onNowPlayingLoadSuccess(List<MovieListModel> movieListModels) {
        logger.d("");
        listPresenter.movieList = movieListModels;
        getViewState().updateNowPlayingRow();
    }

    private void onUpcomingLoadSuccess(List<MovieListModel> movieListModels) {
        logger.d("");
        listPresenter.movieList = movieListModels;
        getViewState().updateUpcomingRow();
    }

    private void onNowPlayingLoadFailed() {
        logger.d("");
    }

    private void onUpcomingLoadFailed() {
        logger.d("");
    }

    public void onBackPressed() {
        router.exit();
    }

    RowListPresenter getListPresenter() {
        return listPresenter;
    }

    public final class RowListPresenter {

        private List<MovieListModel> movieList;

        public RowListPresenter() {
            this.movieList = new ArrayList<>();
        }

        public void bindViewAt(CollectionRowCardView view, int position) {
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

        public int getCollectionItems() {
            return movieList.size();
        }

        public void onClickedRowItem(int position) {
            router.navigateTo(new Screens.DetailMovieScreen(listPresenter.movieList.get(position).getId()));
        }
    }
}