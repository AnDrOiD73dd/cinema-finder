package com.ateam.zuml.cinemafinder.ui.screens.search;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.favorites.AddFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.favorites.RemoveFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.GetMoviesBySearchUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import com.ateam.zuml.cinemafinder.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SearchResponsePresenter extends MvpPresenter<SearchResponseView> {

    private final String movieTitle;

    private SearchListPresenter listPresenter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    @Inject StringUtils stringUtil;
    @Inject GetMoviesBySearchUseCase useCaseGetMoviesBySearch;
    @Inject AddFavoriteMovieUseCase useCaseAddFavoriteMovie;
    @Inject RemoveFavoriteMovieUseCase useCaseRemoveFavoriteMovie;
    @Inject SchedulersProvider schedulers;

    SearchResponsePresenter(String movieTitle) {
        this.movieTitle = movieTitle;
        this.listPresenter = new SearchListPresenter();
    }

    @Override
    public void attachView(SearchResponseView view) {
        super.attachView(view);
        loadData(movieTitle);
    }

    @SuppressLint("CheckResult")
    private void loadData(String movie) {
        getViewState().showLoading();
        useCaseGetMoviesBySearch.execute(movie, "1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_154)
                .observeOn(schedulers.ui())
                .subscribe(this::onLoadSuccess, throwable -> onLoadFailed());
    }

    private void onLoadSuccess(List<MovieListModel> movieListModels) {
        getViewState().hideLoading();
        listPresenter.searchList = movieListModels;
        getViewState().updateSearchList();
        if (movieListModels.isEmpty()) {
            getViewState().showNoSearchResults();
        }
    }

    private void onLoadFailed() {
        getViewState().hideLoading();
        getViewState().showError();
    }

    void onItemClicked(int position) {
        getViewState().closeSearch();
        router.navigateTo(new Screens.DetailMovieScreen(listPresenter.searchList.get(position).getId()));
    }

    //TODO 13.11.2018 add resources class
    @SuppressLint("CheckResult")
    void onFavoritesClicked(boolean isChecked, int position) {
        if (isChecked) {
            useCaseAddFavoriteMovie
                    .execute(listPresenter.searchList.get(position))
                    .observeOn(schedulers.ui())
                    .subscribe(() -> getViewState().showNotifyingMessage("Item added in favorites"),
                            throwable -> getViewState().showNotifyingMessage("Error adding to favorites"));
        } else {
            useCaseRemoveFavoriteMovie
                    .execute(listPresenter.searchList.get(position).getId())
                    .observeOn(schedulers.ui())
                    .subscribe(() -> getViewState().showNotifyingMessage("Item removed from favorites"),
                            throwable -> getViewState().showNotifyingMessage("Error removing from favorites"));
        }
    }

    public void onBackPressed() {
        getViewState().closeSearch();
        router.exit();
    }

    SearchListPresenter getListPresenter() {
        return listPresenter;
    }

    final class SearchListPresenter {

        private List<MovieListModel> searchList;

        SearchListPresenter() {
            this.searchList = new ArrayList<>();
        }

        void bindViewAt(SearchRowView view, int position) {
            MovieListModel movieListModel = searchList.get(position);
            view.setPoster(movieListModel.getPosterPath());
            view.setTitle(movieListModel.getTitle());
            view.setOriginalTitle(movieListModel.getOriginalTitle());
            view.setReleaseDate(stringUtil.addBrackets(movieListModel.getReleaseYear()));
            view.setGenres(stringUtil.getStringFromArrayGenres(movieListModel.getGenres()));
            view.setVoteAverage(movieListModel.getVoteAverage());
            view.setToggleFavorites(false);
        }

        int getSearchCount() {
            return searchList.size();
        }
    }
}