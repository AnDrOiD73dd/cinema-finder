package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.favorites.GetFavoriteMoviesUseCase;
import com.ateam.zuml.cinemafinder.interactor.favorites.RemoveFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
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

    @Inject GetFavoriteMoviesUseCase useCaseGetMovies;
    @Inject RemoveFavoriteMovieUseCase useCaseRemoveMovie;
    @Inject FavoritesRepository repository;
    @Inject SchedulersProvider schedulers;

    @Inject StringUtils stringUtil;

    FavoritesPresenter() {
        this.favoriteListPresenter = new FavoritesListPresenter();
    }

    @Override
    public void attachView(FavoritesView view) {
        super.attachView(view);
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
        useCaseGetMovies.execute()
                .observeOn(schedulers.ui())
                .subscribe(movieListModels -> {
                    favoriteListPresenter.favoritesList = movieListModels;
                    getViewState().updateItemsList();
                });
    }

    void onItemClicked(int position) {
        globalRouter.navigateTo(new Screens.DetailMovieScreen(favoriteListPresenter.favoritesList
                .get(position).getId()));
    }

    //TODO 13.11.2018 add resources class
    @SuppressLint("CheckResult")
    void onRemoveItemClicked(int position) {
        useCaseRemoveMovie
                .execute(favoriteListPresenter.favoritesList.get(position).getId())
                .observeOn(schedulers.ui())
                .subscribe(() -> {
                            getViewState().showNotifyingMessage("Item removed from favorites");
                            favoriteListPresenter.favoritesList.remove(position);
                            getViewState().itemRemoved(position);
                        },
                        throwable -> getViewState().showNotifyingMessage("Error removing from favorites"));
    }

    public void onBackPressed() {
        localRouter.exit();
    }

    FavoritesListPresenter getListPresenter() {
        return favoriteListPresenter;
    }

    final class FavoritesListPresenter {

        private List<MovieListModel> favoritesList;

        FavoritesListPresenter() {
            this.favoritesList = new ArrayList<>();
        }

        void bindViewAt(FavoriteRowView view, int position) {
            MovieListModel movieListModel = favoritesList.get(position);
            view.setPoster(movieListModel.getPosterPath());
            view.setTitle(movieListModel.getTitle());
            view.setOriginalTitle(movieListModel.getOriginalTitle());
            view.setReleaseDate(movieListModel.getReleaseYear());
            view.setGenres(stringUtil.getStringFromArrayGenres(movieListModel.getGenres()));
            view.setVoteAverage(movieListModel.getVoteAverage());
        }

        int getItemsCount() {
            return favoritesList.size();
        }
    }
}
