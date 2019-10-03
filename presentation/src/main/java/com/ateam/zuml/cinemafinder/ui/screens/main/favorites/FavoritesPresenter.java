package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.interactor.favorites.GetFavoriteMoviesUseCase;
import com.ateam.zuml.cinemafinder.interactor.favorites.RemoveFavoriteMovieUseCase;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.ResourceManager;
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

    private final Router localRouter;
    private final Router globalRouter;
    private final GetFavoriteMoviesUseCase useCaseGetMovies;
    private final RemoveFavoriteMovieUseCase useCaseRemoveMovie;
    private final SchedulersProvider schedulers;
    private final ResourceManager resource;

    private final StringUtils stringUtil;

    @Inject
    FavoritesPresenter(@Named(Constants.CHILD_CONTAINER) Router localRouter,
                       @Named(Constants.MAIN_CONTAINER) Router globalRouter,
                       GetFavoriteMoviesUseCase useCaseGetMovies,
                       RemoveFavoriteMovieUseCase useCaseRemoveMovie,
                       SchedulersProvider schedulers, ResourceManager resource,
                       StringUtils stringUtil) {
        this.localRouter = localRouter;
        this.globalRouter = globalRouter;
        this.useCaseGetMovies = useCaseGetMovies;
        this.useCaseRemoveMovie = useCaseRemoveMovie;
        this.schedulers = schedulers;
        this.resource = resource;
        this.stringUtil = stringUtil;
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

    @SuppressLint("CheckResult")
    void onRemoveItemClicked(int position) {
        useCaseRemoveMovie
                .execute(favoriteListPresenter.favoritesList.get(position).getId())
                .observeOn(schedulers.ui())
                .subscribe(() -> {
                            getViewState().showNotifyingMessage(resource.getRemovedFromFavorites());
                            favoriteListPresenter.favoritesList.remove(position);
                            getViewState().itemRemoved(position);
                        },
                        throwable -> getViewState().showNotifyingMessage(resource.getErrorRemoveFromFavorites()));
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
