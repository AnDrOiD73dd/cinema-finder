package com.ateam.zuml.cinemafinder.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.SearchResponseView;
import com.ateam.zuml.cinemafinder.presentation.view.SearchRowView;
import com.ateam.zuml.cinemafinder.ui.MovieModel;
import com.ateam.zuml.cinemafinder.ui.Screens;
import com.ateam.zuml.cinemafinder.util.Const;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SearchResponsePresenter extends MvpPresenter<SearchResponseView> {

    public final class SearchListPresenter  {

        private List<MovieModel> searchList;

        SearchListPresenter() {
            this.searchList = new ArrayList<>();
        }

        public void bindViewAt( SearchRowView view, int position) {
            view.setPoster(searchList.get(position).getPosterPath());
            view.setTitle(searchList.get(position).getTitle());
            view.setOriginalTitle(searchList.get(position).getOriginalTitle());
            view.setReleaseDate(searchList.get(position).getReleaseYear());
            view.setGenres(searchList.get(position).getGenres());
            view.setVoteAverage(searchList.get(position).getVoteAverage());
        }

        public int getSearchCount() {
            return searchList.size();
        }

        public void setSearchList(List<MovieModel> searchList) {
            this.searchList = searchList;
        }
    }

    @Named(Const.MAIN_CONTAINER) @Inject Router router;

    private SearchListPresenter listPresenter;

    public SearchResponsePresenter() {
        this.listPresenter = new SearchListPresenter();
    }

    public SearchListPresenter getListPresenter(List<MovieModel> searchList) {
        //TODO 06.11.2018 stub
        listPresenter.setSearchList(searchList);
        return listPresenter;
    }

    public void showDetailsInfo() {
        getViewState().closeSearch();
        router.navigateTo(new Screens.DetailMovieScreen());
    }
}
