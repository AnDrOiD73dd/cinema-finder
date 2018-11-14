package com.ateam.zuml.cinemafinder.ui.screens.details;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.favorites.AddFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.favorites.RemoveFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.GetMovieDetailsUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.ResourceManager;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import com.ateam.zuml.cinemafinder.util.StringUtils;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class DetailMoviePresenter extends MvpPresenter<DetailMovieView> {

    private final String movieId;

    private MovieDetailsModel currentMovie;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    @Inject StringUtils stringUtil;
    @Inject GetMovieDetailsUseCase detailsUseCase;
    @Inject AddFavoriteMovieUseCase useCaseAddFavoriteMovie;
    @Inject RemoveFavoriteMovieUseCase useCaseRemoveFavoriteMovie;
    @Inject SchedulersProvider schedulers;
    @Inject ResourceManager resource;

    DetailMoviePresenter(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public void attachView(DetailMovieView view) {
        super.attachView(view);
        load(movieId);
    }

    @SuppressLint("CheckResult")
    private void load(String movieId) {
        getViewState().showLoading();
        detailsUseCase.execute(movieId, Language.RUSSIAN, LogoSize.ORIGINAL)
                .observeOn(schedulers.ui())
                .subscribe(this::onLoadSuccess, throwable -> onLoadFailed());
    }

    private void onLoadSuccess(MovieDetailsModel movieDetailsModel) {
        this.currentMovie = movieDetailsModel;
        getViewState().hideLoading();
        getViewState().setToggleFavorites(movieDetailsModel.isFavorite());
        getViewState().setTitle(movieDetailsModel.getTitle());
        getViewState().setSubTitle(String.format(Locale.getDefault(), "%s (%s)",
                movieDetailsModel.getOriginalTitle(), movieDetailsModel.getReleaseYear()));
        getViewState().setPoster(movieDetailsModel.getPosterPath());
        getViewState().setGenresList(stringUtil.getStringFromArrayGenres(movieDetailsModel.getGenres()));
        getViewState().setRuntime(movieDetailsModel.getRuntime());
        getViewState().setVoteAverage(movieDetailsModel.getVoteAverage());
        getViewState().setVoteCount(String.format(Locale.getDefault(), "(%s)", movieDetailsModel.getVoteCount()));
        getViewState().setBudget(String.format(Locale.getDefault(), "%s $", movieDetailsModel.getBudget()));
        getViewState().setRevenue(String.format(Locale.getDefault(), "%s $", movieDetailsModel.getRevenue()));
        getViewState().setReleaseDate(stringUtil.addBrackets(movieDetailsModel.getReleaseDate()));
        getViewState().setTagline(movieDetailsModel.getTagline());
        getViewState().setOverview(movieDetailsModel.getOverview());
    }

    //TODO 13.11.2018 add resources class
    private void onLoadFailed() {
        getViewState().hideLoading();
        getViewState().showNotifyingMessage("An error occurred while loading movie information");
    }

    @SuppressLint("CheckResult")
    void onFavoritesClick(boolean isChecked) {
        if (isChecked) {
            useCaseAddFavoriteMovie
                    .execute(currentMovie)
                    .observeOn(schedulers.ui())
                    .subscribe(() -> {
                            },
                            throwable -> getViewState().showNotifyingMessage(resource.getErrorAddInFavorites()));
        } else {
            useCaseRemoveFavoriteMovie
                    .execute(currentMovie.getId())
                    .observeOn(schedulers.ui())
                    .subscribe(() -> getViewState().showNotifyingMessage(resource.getRemovedFromFavorites()),
                            throwable -> getViewState().showNotifyingMessage(resource.getErrorRemoveFromFavorites()));
        }
    }

    public void onBackPressed() {
        router.exit();
    }
}
