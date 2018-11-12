package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.repository.FavoritesRepository;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import com.ateam.zuml.cinemafinder.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class FavoritesPresenter extends MvpPresenter<FavoritesView> {

    private final FavoritesListPresenter favoriteListPresenter;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router localRouter;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router globalRouter;

    @Inject FavoritesRepository repository;
    @Inject SchedulersProvider schedulers;

    @Inject StringUtils stringUtil;

    public FavoritesPresenter() {
        this.favoriteListPresenter = new FavoritesListPresenter();
    }

    @Override
    public void attachView(FavoritesView view) {
        super.attachView(view);
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
        repository.getAllMovies(LogoSize.W_154)
                .observeOn(schedulers.ui())
                .subscribe(movieDetailsModels -> favoriteListPresenter.favoritesList = movieDetailsModels);
        getViewState().updateItemsList();
    }

    public void onItemClicked(int position) {
        globalRouter.navigateTo(new Screens.DetailMovieScreen(favoriteListPresenter.favoritesList
                .get(position).getId()));
    }

    public void onRemoveItemClick(int position) {
        favoriteListPresenter.favoritesList.remove(position);
        getViewState().itemRemoved(position);
    }

    public void onBackPressed() {
        localRouter.exit();
    }

    FavoritesListPresenter getListPresenter() {
        return favoriteListPresenter;
    }

    final class FavoritesListPresenter {

        private List<MovieDetailsModel> favoritesList;

        FavoritesListPresenter() {
            this.favoritesList = new ArrayList<>();
        }

        void bindViewAt(FavoriteRowView view, int position) {
            MovieDetailsModel movieDetailsModel = favoritesList.get(position);
            view.setPoster(movieDetailsModel.getPosterPath());
            view.setTitle(movieDetailsModel.getTitle());
            view.setOriginalTitle(movieDetailsModel.getOriginalTitle());
            view.setReleaseDate(movieDetailsModel.getReleaseYear());
            view.setGenres(stringUtil.getStringFromArrayGenres(movieDetailsModel.getGenres()));
            view.setVoteAverage(movieDetailsModel.getVoteAverage());
        }

        int getItemsCount() {
            return favoritesList.size();
        }
    }
}
