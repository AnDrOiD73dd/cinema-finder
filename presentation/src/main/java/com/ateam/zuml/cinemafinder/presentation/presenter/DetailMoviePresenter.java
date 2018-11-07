package com.ateam.zuml.cinemafinder.presentation.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.movie.GetMovieDetailsUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.presentation.view.DetailMovieView;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.StringUtil;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class DetailMoviePresenter extends MvpPresenter<DetailMovieView> {

    @Inject
    StringUtil stringUtil;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    @Inject GetMovieDetailsUseCase useCase;

    private final String movieId;

    public DetailMoviePresenter(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public void attachView(DetailMovieView view) {
        super.attachView(view);
        getViewState().showProgressBar();
        load(movieId);
    }

    @SuppressLint("CheckResult")
    private void load(String movieId) {
        useCase.execute(movieId, Language.RUSSIAN, LogoSize.ORIGINAL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadSuccess, throwable -> onLoadFailed());
    }

    private void onLoadSuccess(MovieDetailsModel movieDetailsModel) {
        getViewState().hideProgressBar();
        getViewState().setTitle(movieDetailsModel.getTitle());
        getViewState().setOriginalTitle(movieDetailsModel.getOriginalTitle());
        getViewState().setPoster(movieDetailsModel.getPosterPath());
        getViewState().setGenresList(stringUtil.getStringFromArrayGenres(movieDetailsModel.getGenres()));
        getViewState().setReleaseYear(movieDetailsModel.getReleaseYear());
        getViewState().setRuntime(movieDetailsModel.getRuntime());
        getViewState().setVoteAverage(movieDetailsModel.getVoteAverage());
        getViewState().setVoteCount(String.format(Locale.getDefault(), "(%s)", movieDetailsModel.getVoteCount()));
        getViewState().setBudget(String.format(Locale.getDefault(), "%s $", movieDetailsModel.getBudget()));
        getViewState().setRevenue(String.format(Locale.getDefault(), "%s $", movieDetailsModel.getRevenue()));
        getViewState().setReleaseDate(movieDetailsModel.getReleaseDate());
        getViewState().setTagline(movieDetailsModel.getTagline());
        getViewState().setOverview(movieDetailsModel.getOverview());
    }

    private void onLoadFailed() {
        getViewState().hideProgressBar();
        getViewState().showError();
    }

    public void onBackPressed() {
        router.exit();
    }
}
