package com.ateam.zuml.cinemafinder.ui.common.collection;

import android.annotation.SuppressLint;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.movie.GetNowPlayingMoviesUseCase;
import com.ateam.zuml.cinemafinder.interactor.movie.GetPopularMoviesUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.CollectionsRow;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class CollectionRowPresenter extends MvpPresenter<CollectionRowView> {

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

    private CollectionsRow collection;
    private RowListPresenter listPresenter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    @Inject GetPopularMoviesUseCase useCasePopular;
    @Inject GetNowPlayingMoviesUseCase useCaseNowPlaying;
    @Inject SchedulersProvider schedulers;

    CollectionRowPresenter(CollectionsRow collection) {
        this.collection = collection;
        this.listPresenter = new RowListPresenter();
    }

    RowListPresenter getListPresenter() {
        return listPresenter;
    }

    @Override
    public void attachView(CollectionRowView view) {
        super.attachView(view);
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
        getViewState().showLoading();
        if (collection == CollectionsRow.POPULAR) {
            useCasePopular.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
                    .observeOn(schedulers.ui())
                    .subscribe(this::onLoadSuccess, throwable -> onLoadFailed());
        } else if (collection == CollectionsRow.NOW_PLAYING) {
            useCaseNowPlaying.execute("1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_300)
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
}