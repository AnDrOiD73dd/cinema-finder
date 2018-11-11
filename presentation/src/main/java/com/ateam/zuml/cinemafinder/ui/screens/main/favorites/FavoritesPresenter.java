package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.navigation.Screens;
import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class FavoritesPresenter extends MvpPresenter<FavoritesView> {

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    Router router;

    @Inject StringUtils stringUtil;

    private final FavoritesListPresenter favoriteListPresenter;

    public FavoritesPresenter() {
        this.favoriteListPresenter = new FavoritesListPresenter();
    }

    @Override
    public void attachView(FavoritesView view) {
        super.attachView(view);
        loadData();
    }

    private void loadData() {

    }

    public void onBackPressed() {
        router.exit();
    }

    public FavoritesListPresenter getListPresenter() {
        return favoriteListPresenter;
    }

    public void onItemClicked(int position) {
        router.navigateTo(new Screens.DetailMovieScreen(favoriteListPresenter.favoritesList
                .get(position).getId()));
    }

    public void onRemoveItemClick(int position) {
        favoriteListPresenter.favoritesList.remove(position);
        getViewState().itemRemoved(position);
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
