package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.favorites.AddFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.favorites.RemoveFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.GetPopularMoviesUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.ui.common.collection_row.CollectionRowCardView;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class RatingsPresenter extends MvpPresenter<RatingsView> {

    private RatingsRowListPresenter firstPresenter;
    private RatingsRowListPresenter secondPresenter;
    private RatingsRowListPresenter thirdPresenter;
    private RatingsRowListPresenter fourthPresenter;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router localRouter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router globalRouter;

    @Inject GetPopularMoviesUseCase useCase;
    @Inject AddFavoriteMovieUseCase useCaseAddFavoriteMovie;
    @Inject RemoveFavoriteMovieUseCase useCaseRemoveFavoriteMovie;
    @Inject SchedulersProvider schedulers;

    RatingsPresenter() {
        this.firstPresenter = new RatingsRowListPresenter();
        this.secondPresenter = new RatingsRowListPresenter();
        this.thirdPresenter = new RatingsRowListPresenter();
        this.fourthPresenter = new RatingsRowListPresenter();
    }

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadFirstData();
        loadSecondData();
        loadThirdData();
        loadFourthData();
    }

    @SuppressLint("CheckResult")
    private void loadFirstData() {
        getViewState().showFirstLoading();
        useCase.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onFirstLoadSuccess, throwable -> onFirstLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadSecondData() {
        getViewState().showFirstLoading();
        useCase.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onSecondLoadSuccess, throwable -> onSecondLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadThirdData() {
        getViewState().showFirstLoading();
        useCase.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onThirdLoadSuccess, throwable -> onThirdLoadFailed());
    }

    @SuppressLint("CheckResult")
    private void loadFourthData() {
        getViewState().showFirstLoading();
        useCase.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                .observeOn(schedulers.ui())
                .subscribe(this::onFourthLoadSuccess, throwable -> onFourthLoadFailed());
    }

    private void onFirstLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideFirstLoading();
        firstPresenter.movieList = movieListModels;
        getViewState().updateFirstRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInFirst();
        }
    }

    private void onSecondLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideSecondLoading();
        secondPresenter.movieList = movieListModels;
        getViewState().updateSecondRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInSecond();
        }
    }

    private void onThirdLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideThirdLoading();
        thirdPresenter.movieList = movieListModels;
        getViewState().updateThirdRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInThird();
        }
    }

    private void onFourthLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideFourthLoading();
        fourthPresenter.movieList = movieListModels;
        getViewState().updateFourthRow();
        if (movieListModels.isEmpty()) {
            getViewState().showNoInFourth();
        }
    }

    //TODO 13.11.2018 add resources class
    private void onFirstLoadFailed() {
        getViewState().hideFirstLoading();
        getViewState().showNoInFirst();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    //TODO 13.11.2018 add resources class
    private void onSecondLoadFailed() {
        getViewState().hideSecondLoading();
        getViewState().showNoInSecond();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    //TODO 13.11.2018 add resources class
    private void onThirdLoadFailed() {
        getViewState().hideThirdLoading();
        getViewState().showNoInThird();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    //TODO 13.11.2018 add resources class
    private void onFourthLoadFailed() {
        getViewState().hideFourthLoading();
        getViewState().showNoInFourth();
        getViewState().showNotifyingMessage("An error occurred while loading collection category");
    }

    public void onBackPressed() {
        localRouter.exit();
    }

    RatingsRowListPresenter getFirstPresenter() {
        return firstPresenter;
    }

    RatingsRowListPresenter getSecondPresenter() {
        return secondPresenter;
    }

    RatingsRowListPresenter getThirdPresenter() {
        return thirdPresenter;
    }

    RatingsRowListPresenter getFourthPresenter() {
        return fourthPresenter;
    }

    final class RatingsRowListPresenter {

        private List<MovieListModel> movieList;

        RatingsRowListPresenter() {
            this.movieList = new ArrayList<>();
        }

        void bindViewAt(CollectionRowCardView view, int position) {
            MovieListModel movieListModel = movieList.get(position);
            view.setPoster(movieListModel.getPosterPath());
            view.setTitle(movieListModel.getTitle());
            view.setVoteAverage(movieListModel.getVoteAverage());
            view.setReleaseDate(movieListModel.getReleaseYear());
        }

        int getCollectionItems() {
            return movieList.size();
        }

        void onClickedRowItem(int position) {
            globalRouter.navigateTo(new Screens.DetailMovieScreen(movieList.get(position).getId()));
        }

        //TODO 13.11.2018 add resources class
        @SuppressLint("CheckResult")
        void onFavoritesClicked(boolean isChecked, int position) {
            if (isChecked) {
                useCaseAddFavoriteMovie
                        .execute(movieList.get(position))
                        .observeOn(schedulers.ui())
                        .subscribe(() -> getViewState().showNotifyingMessage("Item added in favorites"),
                                throwable -> getViewState().showNotifyingMessage("Error adding to favorites"));
            } else {
                useCaseRemoveFavoriteMovie
                        .execute(movieList.get(position).getId())
                        .observeOn(schedulers.ui())
                        .subscribe(() -> getViewState().showNotifyingMessage("Item removed from favorites"),
                                throwable -> getViewState().showNotifyingMessage("Error removing from favorites"));
            }
        }
    }
}
