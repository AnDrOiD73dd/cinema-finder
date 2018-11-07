package com.ateam.zuml.cinemafinder.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.presentation.view.DetailMovieView;
import com.ateam.zuml.cinemafinder.util.StringUtil;

import javax.inject.Inject;


@InjectViewState
public class DetailMoviePresenter extends MvpPresenter<DetailMovieView> {

    @Inject
    StringUtil stringUtil;
    private final String movieId;

    public DetailMoviePresenter(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public void attachView(DetailMovieView view) {
        super.attachView(view);
        getViewState().showProgressBar();
        load(movieId);
        showStubData(); // TODO delete it after add load real data
    }

    private void load(String movieId) {
        // TODO load movie details by id
    }

    private void showStubData() {
        getViewState().hideProgressBar();
        getViewState().setTitle("Title");
        getViewState().setOriginalTitle("Original title");
        String[] genresList = new String[] {"Genre 1", "Genre 2", "Genre 3"};
        getViewState().setGenresList(stringUtil.getStringFromArrayGenres(genresList));
        getViewState().setReleaseYear("2016");
        getViewState().setRuntime("120");
        getViewState().setVoteAverage("7.8");
        getViewState().setVoteCount("3476");
        getViewState().setBudget("63 000 000");
        getViewState().setRevenue("750 000 000");
        getViewState().setReleaseDate("2015-09-22");
        getViewState().setTagline("How much can you know about yourself if you've never been in a fight?");
        getViewState().setOverview("A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground fight clubs forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.");
    }

    private void onLoadSuccess(MovieDetailsModel movieDetailsModel) {
        getViewState().hideProgressBar();
        getViewState().setTitle(movieDetailsModel.getTitle());
        getViewState().setOriginalTitle(movieDetailsModel.getOriginalTitle());
        getViewState().setPoster(movieDetailsModel.getPosterPath());  // TODO: load image over ImageLoader
        getViewState().setGenresList(stringUtil.getStringFromArrayGenres(movieDetailsModel.getGenres()));
        getViewState().setReleaseYear(movieDetailsModel.getReleaseYear());
        getViewState().setRuntime(movieDetailsModel.getRuntime());
        getViewState().setVoteAverage(movieDetailsModel.getVoteAverage());
        getViewState().setVoteCount(movieDetailsModel.getVoteCount());
        getViewState().setBudget(movieDetailsModel.getBudget());
        getViewState().setRevenue(movieDetailsModel.getRevenue());
        getViewState().setReleaseDate(movieDetailsModel.getReleaseDate());
        getViewState().setTagline(movieDetailsModel.getTagline());
        getViewState().setOverview(movieDetailsModel.getOverview());
    }

    private void onLoadFailed() {
        getViewState().hideProgressBar();
        getViewState().showError();
    }
}
