package com.ateam.zuml.cinemafinder.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.presentation.view.SearchResponseView;
import com.ateam.zuml.cinemafinder.presentation.view.SearchRowView;
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

        private List<MovieListModel> searchList;

        SearchListPresenter() {
            this.searchList = new ArrayList<>();
        }

        public void bindViewAt( SearchRowView view, int position) {
            //FIXME 06.11.2018 add Picasso
            view.setPoster(R.drawable.ic_broken_image);
            view.setTitle(searchList.get(position).getTitle());
            view.setOriginalTitle(searchList.get(position).getOriginalTitle());
            view.setReleaseDate(searchList.get(position).getReleaseYear());
            view.setGenres(getStringFromArrayGenres(searchList.get(position).getGenres()));
            view.setVoteAverage(searchList.get(position).getVoteAverage());
        }

        public int getSearchCount() {
            return searchList.size();
        }

        public void setSearchList(List<MovieListModel> searchList) {
            this.searchList = searchList;
        }

        private String getStringFromArrayGenres(String[] arr) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if(arr.length == 1 || i == (arr.length - 1)) {
                    break;
                }
                sb.append(", ");
            }

            return sb.toString();
        }
    }

    @Named(Const.MAIN_CONTAINER) @Inject Router router;

    private SearchListPresenter listPresenter;

    public SearchResponsePresenter() {
        this.listPresenter = new SearchListPresenter();
    }

    public SearchListPresenter getListPresenter(List<MovieListModel> searchList) {
        //TODO 06.11.2018 stub
        listPresenter.setSearchList(searchList);
        return listPresenter;
    }

    public void showDetailsInfo() {
        getViewState().closeSearch();
        router.navigateTo(new Screens.DetailMovieScreen());
    }
}
