package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.favorites.AddFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.favorites.RemoveFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.GetNowPlayingMoviesUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.GetUpcomingMoviesUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.ui.common.CollectionRowCardView;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.Logger;
import com.ateam.zuml.cinemafinder.util.ResourceManager;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {

    private RowListPresenter nowPlayingPresenter;
    private RowListPresenter upcomingPresenter;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router localRouter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router globalRouter;

    @Inject GetNowPlayingMoviesUseCase useCaseNowPlaying;
    @Inject GetUpcomingMoviesUseCase useCaseUpcoming;
    @Inject AddFavoriteMovieUseCase useCaseAddFavoriteMovie;
    @Inject RemoveFavoriteMovieUseCase useCaseRemoveFavoriteMovie;
    @Inject SchedulersProvider schedulers;
    @Inject ResourceManager resource;
    @Inject Logger logger;

    public HomePresenter() {
        this.nowPlayingPresenter = new RowListPresenter();
        this.upcomingPresenter = new RowListPresenter();
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
        getViewState().showNowPlayingLoading();
        useCaseNowPlaying
                .execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onNowPlayingLoadSuccess, throwable -> onNowPlayingLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadUpcomingData() {
        logger.d("");
        getViewState().showUpcomingLoading();
        useCaseUpcoming
                .execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onUpcomingLoadSuccess, throwable -> onUpcomingLoadFailed());
    }

    private void onNowPlayingLoadSuccess(List<MovieListModel> movieListModels) {
        logger.d("");
        getViewState().hideNowPlayingLoading();
        nowPlayingPresenter.movieList = movieListModels;
        getViewState().updateNowPlayingRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInNowPlaying();
        }
    }

    private void onUpcomingLoadSuccess(List<MovieListModel> movieListModels) {
        logger.d("");
        getViewState().hideUpcomingLoading();
        upcomingPresenter.movieList = movieListModels;
        getViewState().updateUpcomingRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInUpcoming();
        }
    }

    //TODO 13.11.2018 add resources class
    private void onNowPlayingLoadFailed() {
        logger.d("");
        getViewState().hideNowPlayingLoading();
        getViewState().showNoInNowPlaying();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    //TODO 13.11.2018 add resources class
    private void onUpcomingLoadFailed() {
        logger.d("");
        getViewState().hideUpcomingLoading();
        getViewState().showNoInUpcoming();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    public void onBackPressed() {
        localRouter.exit();
    }

    RowListPresenter getNowPlayingPresenter() {
        return nowPlayingPresenter;
    }

    RowListPresenter getUpcomingPresenter() {
        return upcomingPresenter;
    }

    final class RowListPresenter {

        private List<MovieListModel> movieList;

        RowListPresenter() {
            this.movieList = new ArrayList<>();
        }

        void bindViewAt(CollectionRowCardView view, int position) {
            MovieListModel movieListModel = movieList.get(position);
            view.setPoster(movieListModel.getPosterPath());
            view.setTitle(movieListModel.getTitle());
            view.setVoteAverage(movieListModel.getVoteAverage());
            view.setReleaseDate(movieListModel.getReleaseYear());
            view.setToggleFavorites(movieListModel.isFavorite());
        }

        int getCollectionItems() {
            return movieList.size();
        }

        void onClickedRowItem(int position) {
            globalRouter.navigateTo(new Screens.DetailMovieScreen(movieList.get(position).getId()));
        }

        @SuppressLint("CheckResult")
        void onFavoritesClicked(boolean isChecked, int position) {
            if (isChecked) {
                useCaseAddFavoriteMovie
                        .execute(movieList.get(position))
                        .observeOn(schedulers.ui())
                        .subscribe(() -> {
                                },
                                throwable -> getViewState().showNotifyingMessage(resource.getErrorAddInFavorites()));
            } else {
                useCaseRemoveFavoriteMovie
                        .execute(movieList.get(position).getId())
                        .observeOn(schedulers.ui())
                        .subscribe(() -> getViewState().showNotifyingMessage(resource.getRemovedFromFavorites()),
                                throwable -> getViewState().showNotifyingMessage(resource.getErrorRemoveFromFavorites()));
            }
        }
    }
}