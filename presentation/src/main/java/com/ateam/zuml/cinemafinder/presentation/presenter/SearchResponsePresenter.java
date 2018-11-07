package com.ateam.zuml.cinemafinder.presentation.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.movie.GetMoviesBySearchUseCase;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.presentation.view.SearchResponseView;
import com.ateam.zuml.cinemafinder.presentation.view.SearchRowView;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class SearchResponsePresenter extends MvpPresenter<SearchResponseView> {

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    @Inject
    StringUtil stringUtil;

    @Inject
    GetMoviesBySearchUseCase useCase;

    private final String movieTitle;
    private SearchListPresenter listPresenter;

    public SearchResponsePresenter(String movieTitle) {
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
        //TODO 07.11.2018 optimize query
        useCase.execute(movie, "1", Language.RUSSIAN, Region.RUSSIAN, LogoSize.W_154)
                //TODO 07.11.2018 add SchedulersProvider
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieListModels -> {
                    listPresenter.searchList = movieListModels;
                    getViewState().updateSearchList();
                }, throwable -> {
                    //TODO 07.11.2018 add show error
                });
    }

    public SearchListPresenter getListPresenter() {
        return listPresenter;
    }

    public void showDetailsInfo(int position) {
        getViewState().closeSearch();
        router.navigateTo(new Screens.DetailMovieScreen(listPresenter.searchList.get(position).getId()));
    }

    public void onBackPressed() {
        getViewState().closeSearch();
        router.exit();
    }

    public final class SearchListPresenter {

        private List<MovieListModel> searchList;

        SearchListPresenter() {
            this.searchList = new ArrayList<>();
        }

        public void bindViewAt(SearchRowView view, int position) {
            view.setPoster(searchList.get(position).getPosterPath());
            view.setTitle(searchList.get(position).getTitle());
            view.setOriginalTitle(searchList.get(position).getOriginalTitle());
            view.setReleaseDate(searchList.get(position).getReleaseYear());
            view.setGenres(stringUtil.getStringFromArrayGenres(searchList.get(position).getGenres()));
            view.setVoteAverage(searchList.get(position).getVoteAverage());
        }

        public int getSearchCount() {
            return searchList.size();
        }
    }
}

