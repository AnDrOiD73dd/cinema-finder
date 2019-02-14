package com.ateam.zuml.cinemafinder.ui.screens.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.BaseFragment;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class DetailMovieFragment extends BaseFragment implements DetailMovieView, BackButtonListener {

    public static final String KEY_MOVIE_ID = "key_movie_id";

    @BindView(R.id.movie_detail_root) ConstraintLayout rootView;
    @BindView(R.id.tb_movie_detail) ToggleButton toggleFavorites;
    @BindView(R.id.tv_movie_title) TextView titleView;
    @BindView(R.id.tv_movie_subtitle) TextView subTitleView;
    @BindView(R.id.iv_movie_poster) AppCompatImageView posterView;
    @BindView(R.id.tv_movie_genres_list) TextView genresListView;
    @BindView(R.id.tv_movie_runtime) TextView runtimeView;
    @BindView(R.id.tv_movie_vote_average) TextView voteAverageView;
    @BindView(R.id.tv_movie_vote_count) TextView voteCountView;
    @BindView(R.id.tv_movie_budget) TextView budgetView;
    @BindView(R.id.tv_movie_revenue) TextView revenueView;
    @BindView(R.id.tv_movie_release_date) TextView releaseDateView;
    @BindView(R.id.tv_movie_tagline) TextView taglineView;
    @BindView(R.id.tv_movie_adult) TextView adultView;
    @BindView(R.id.tv_movie_overview) TextView descriptionView;
    @BindView(R.id.pb_movie_detail) ProgressBar progressBarView;

    @Inject ImageLoader imageLoader;
    @Inject Provider<DetailMoviePresenter> presenterProvider;

    @InjectPresenter DetailMoviePresenter presenter;

    public static DetailMovieFragment newInstance(String movieId) {
        DetailMovieFragment fragment = new DetailMovieFragment();
        Bundle args = new Bundle();
        args.putString(KEY_MOVIE_ID, movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    public DetailMoviePresenter provideDetailMoviePresenter() {
        DetailMoviePresenter presenter = presenterProvider.get();
        presenter.setMovieId(getMovieId());
        return presenter;
    }

    private String getMovieId() {
        Bundle bundle = getArguments();
        String movieId = "";
        if (bundle != null && bundle.containsKey(KEY_MOVIE_ID)) {
            movieId = bundle.getString(KEY_MOVIE_ID);
        }
        return movieId;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_movie, container, false);
        init(view);
        setupToolbar(R.string.movie_detail, true);
        return view;
    }

    private void init(View view) {
        ButterKnife.bind(this, view);
        toggleFavorites.setOnCheckedChangeListener((buttonView, isChecked) -> presenter.onFavoritesClick(isChecked));
    }

    //region ### DetailMovieView ###
    @Override
    public void showLoading() {
        progressBarView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBarView.setVisibility(View.GONE);
    }

    @Override
    public void showNotifyingMessage(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setToggleFavorites(boolean isFavorite) {
        toggleFavorites.setChecked(isFavorite);
    }

    @Override
    public void setPoster(String imagePath) {
        imageLoader.loadInto(imagePath, posterView);
    }

    @Override
    public void setTitle(String titleText) {
        titleView.setText(titleText);
    }

    @Override
    public void setSubTitle(String subTitleText) {
        subTitleView.setText(subTitleText);
    }

    @Override
    public void setGenresList(String genresList) {
        genresListView.setText(genresList);
    }

    @Override
    public void setRuntime(String runtime) {
        String postfix = getResources().getString(R.string.movie_details_minutes);
        runtimeView.setText(String.format(Locale.getDefault(), "%s %s", runtime, postfix));
    }

    @Override
    public void setVoteAverage(String voteAverage) {
        voteAverageView.setText(voteAverage);
    }

    @Override
    public void setVoteCount(String voteCount) {
        voteCountView.setText(voteCount);
    }

    @Override
    public void setBudget(String budget) {
        budgetView.setText(budget);
    }

    @Override
    public void setRevenue(String revenue) {
        revenueView.setText(revenue);
    }

    @Override
    public void setReleaseDate(String releaseDate) {
        releaseDateView.setText(releaseDate);
    }

    @Override
    public void setTagline(String tagline) {
        taglineView.setText(tagline);
    }

    @Override
    public void showAdult() {
        adultView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideAdult() {
        adultView.setVisibility(View.GONE);
    }

    @Override
    public void setOverview(String overviewText) {
        descriptionView.setText(overviewText);
    }
    //endregion

    //region ### BackButtonListener ###
    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
    //endregion
}
