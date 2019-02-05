package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.favorites.AddFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.favorites.RemoveFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.ratings.GetActionRatingsUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.ratings.GetAnimationRatingsUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.ratings.GetComedyRatingsUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.ratings.GetTopRatingsUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.ResourceManager;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class RatingsPresenter extends MvpPresenter<RatingsView> {

    private RatingsRowListPresenter topMoviesPresenter;
    private RatingsRowListPresenter topActionsPresenter;
    private RatingsRowListPresenter topComediesPresenter;
    private RatingsRowListPresenter topAnimationsPresenter;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router localRouter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router globalRouter;

    @Inject GetTopRatingsUseCase useCaseGetTopRatings;
    @Inject GetActionRatingsUseCase useCaseGetActionRatings;
    @Inject GetComedyRatingsUseCase useCaseGetComedyRatings;
    @Inject GetAnimationRatingsUseCase useCaseGetAnimationRatings;
    @Inject AddFavoriteMovieUseCase useCaseAddFavoriteMovie;
    @Inject RemoveFavoriteMovieUseCase useCaseRemoveFavoriteMovie;
    @Inject SchedulersProvider schedulers;
    @Inject ResourceManager resource;

    RatingsPresenter() {
        this.topMoviesPresenter = new RatingsRowListPresenter();
        this.topActionsPresenter = new RatingsRowListPresenter();
        this.topComediesPresenter = new RatingsRowListPresenter();
        this.topAnimationsPresenter = new RatingsRowListPresenter();
    }

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadTopMoviesData();
        loadTopActionsData();
        loadTopComediesData();
        loadTopAnimationsData();
    }

    @SuppressLint("CheckResult")
    private void loadTopMoviesData() {
        getViewState().showTopMoviesLoading();
        useCaseGetTopRatings.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onTopMoviesLoadSuccess, throwable -> onTopMoviesLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadTopActionsData() {
        getViewState().showTopActionsLoading();
        useCaseGetActionRatings.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onTopActionsLoadSuccess, throwable -> onTopActionsLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadTopComediesData() {
        getViewState().showTopComediesLoading();
        useCaseGetComedyRatings.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onTopComediesLoadSuccess, throwable -> onTopComediesLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadTopAnimationsData() {
        getViewState().showTopAnimationsLoading();
        useCaseGetAnimationRatings.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onTopAnimationsLoadSuccess, throwable -> onTopAnimationsLoadFailed());
    }

    private void onTopMoviesLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideTopMoviesLoading();
        topMoviesPresenter.movieList = movieListModels;
        getViewState().updateTopMoviesRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInTopMovies();
        }
    }

    private void onTopActionsLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideTopActionsLoading();
        topActionsPresenter.movieList = movieListModels;
        getViewState().updateTopActionsRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInTopActions();
        }
    }

    private void onTopComediesLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideTopComediesLoading();
        topComediesPresenter.movieList = movieListModels;
        getViewState().updateTopComediesRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInTopComedies();
        }
    }

    private void onTopAnimationsLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideTopAnimationsLoading();
        topAnimationsPresenter.movieList = movieListModels;
        getViewState().updateTopAnimationsRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInTopAnimations();
        }
    }

    //TODO 13.11.2018 add resources class
    private void onTopMoviesLoadFailed() {
        getViewState().hideTopMoviesLoading();
        getViewState().showNoInTopMovies();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    //TODO 13.11.2018 add resources class
    private void onTopActionsLoadFailed() {
        getViewState().hideTopActionsLoading();
        getViewState().showNoInTopActions();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    //TODO 13.11.2018 add resources class
    private void onTopComediesLoadFailed() {
        getViewState().hideTopComediesLoading();
        getViewState().showNoInTopComedies();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    //TODO 13.11.2018 add resources class
    private void onTopAnimationsLoadFailed() {
        getViewState().hideTopAnimationsLoading();
        getViewState().showNoInTopAnimations();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    public void onBackPressed() {
        localRouter.exit();
    }

    RatingsRowListPresenter getTopMoviesPresenter() {
        return topMoviesPresenter;
    }

    RatingsRowListPresenter getTopActionsPresenter() {
        return topActionsPresenter;
    }

    RatingsRowListPresenter getTopComediesPresenter() {
        return topComediesPresenter;
    }

    RatingsRowListPresenter getTopAnimationsPresenter() {
        return topAnimationsPresenter;
    }

    public void onSwipeForRefreshScreen() {
        loadTopMoviesData();
        loadTopActionsData();
        loadTopComediesData();
        loadTopAnimationsData();
        getViewState().finishSwipeGestureAction();
    }

    final class RatingsRowListPresenter {

        private List<MovieListModel> movieList;

        RatingsRowListPresenter() {
            this.movieList = new ArrayList<>();
        }

        void bindViewAt(RatingsRowCardView view, int position) {
            MovieListModel movieListModel = movieList.get(position);
            view.setPoster(movieListModel.getPosterPath());
            view.setTitle(movieListModel.getTitle());
            //TODO 14.11.2018 optimize this
            view.setRankingPosition(String.valueOf(position + 1));
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
        void onFavoritesClicked(int position) {
            if (movieList.get(position).isFavorite()) {
                useCaseRemoveFavoriteMovie
                        .execute(movieList.get(position).getId())
                        .observeOn(schedulers.ui())
                        .subscribe(() -> getViewState().showNotifyingMessage(resource.getRemovedFromFavorites()),
                                throwable -> getViewState().showNotifyingMessage(resource.getErrorRemoveFromFavorites()));
            } else {
                useCaseAddFavoriteMovie
                        .execute(movieList.get(position))
                        .observeOn(schedulers.ui())
                        .subscribe(() -> {
                                },
                                throwable -> getViewState().showNotifyingMessage(resource.getErrorAddInFavorites()));
            }
        }
    }
}
