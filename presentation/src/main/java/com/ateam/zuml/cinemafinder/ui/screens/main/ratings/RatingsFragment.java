package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.BaseFragment;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingsFragment extends BaseFragment implements RatingsView, BackButtonListener {

    private RatingsCollectionRowAdapter topMoviesAdapter;
    private RatingsCollectionRowAdapter topActionsAdapter;
    private RatingsCollectionRowAdapter topComediesAdapter;
    private RatingsCollectionRowAdapter topAnimationsAdapter;

    @BindView(R.id.sr_ratings) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.ratings_root) LinearLayout rootView;

    @BindView(R.id.tv_top_movies_row_name) TextView topMoviesTitleView;
    @BindView(R.id.rv_top_movies_row) RecyclerView topMoviesRecyclerView;
    @BindView(R.id.pb_top_movies_row) ProgressBar topMoviesProgressBar;
    @BindView(R.id.tv_top_movies_row_no_results) TextView topMoviesNoResultsView;

    @BindView(R.id.tv_top_actions_row_name) TextView topActionsTitleView;
    @BindView(R.id.rv_top_actions_row) RecyclerView topActionsRecyclerView;
    @BindView(R.id.pb_top_actions_row) ProgressBar topActionsProgressBar;
    @BindView(R.id.tv_top_actions_row_no_results) TextView topActionsNoResultsView;

    @BindView(R.id.tv_top_comedies_row_name) TextView topComediesTitleView;
    @BindView(R.id.rv_top_comedies_row) RecyclerView topComediesRecyclerView;
    @BindView(R.id.pb_top_comedies_row) ProgressBar topComediesProgressBar;
    @BindView(R.id.tv_top_comedies_row_no_results) TextView topComediesNoResultsView;

    @BindView(R.id.tv_top_animations_row_name) TextView topAnimationsTitleView;
    @BindView(R.id.rv_top_animations_row) RecyclerView topAnimationsRecyclerView;
    @BindView(R.id.pb_top_animations_row) ProgressBar topAnimationsProgressBar;
    @BindView(R.id.tv_top_animations_row_no_results) TextView topAnimationsNoResultsView;

    @Inject ImageLoader imageLoader;

    @InjectPresenter RatingsPresenter presenter;

    public static RatingsFragment newInstance() {
        return new RatingsFragment();
    }

    @ProvidePresenter
    RatingsPresenter provideRatingsPresenter() {
        RatingsPresenter presenter = new RatingsPresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ratings, container, false);
        init(view);
        setupRecyclerView(topMoviesRecyclerView, topMoviesAdapter);
        setupRecyclerView(topActionsRecyclerView, topActionsAdapter);
        setupRecyclerView(topComediesRecyclerView, topComediesAdapter);
        setupRecyclerView(topAnimationsRecyclerView, topAnimationsAdapter);
        setupToolbar(R.string.ratings, false);
        return view;
    }

    private void init(View view) {
        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, view);
        topMoviesAdapter = new RatingsCollectionRowAdapter(presenter.getTopMoviesPresenter(), imageLoader);
        topActionsAdapter = new RatingsCollectionRowAdapter(presenter.getTopActionsPresenter(), imageLoader);
        topComediesAdapter = new RatingsCollectionRowAdapter(presenter.getTopComediesPresenter(), imageLoader);
        topAnimationsAdapter = new RatingsCollectionRowAdapter(presenter.getTopAnimationsPresenter(), imageLoader);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.onSwipeForRefreshScreen());
        swipeRefreshLayout.setColorSchemeResources(
                R.color.swipe_color_1, R.color.swipe_color_2,
                R.color.swipe_color_3, R.color.swipe_color_4);
    }

    private void setupRecyclerView(RecyclerView recyclerView, RatingsCollectionRowAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh_data:
                swipeRefreshLayout.setRefreshing(true);
                presenter.onSwipeForRefreshScreen();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //region ### RatingsView ###
    @Override
    public void updateTopMoviesRow() {
        topMoviesAdapter.refreshView();
    }

    @Override
    public void updateTopActionsRow() {
        topActionsAdapter.refreshView();
    }

    @Override
    public void updateTopComediesRow() {
        topComediesAdapter.refreshView();
    }

    @Override
    public void updateTopAnimationsRow() {
        topAnimationsAdapter.refreshView();
    }

    @Override
    public void showTopMoviesLoading() {
        topMoviesProgressBar.setVisibility(View.VISIBLE);
        topMoviesTitleView.setVisibility(View.GONE);
    }

    @Override
    public void showTopActionsLoading() {
        topActionsProgressBar.setVisibility(View.VISIBLE);
        topActionsTitleView.setVisibility(View.GONE);
    }

    @Override
    public void showTopComediesLoading() {
        topComediesProgressBar.setVisibility(View.VISIBLE);
        topComediesTitleView.setVisibility(View.GONE);
    }


    @Override
    public void showTopAnimationsLoading() {
        topAnimationsProgressBar.setVisibility(View.VISIBLE);
        topAnimationsTitleView.setVisibility(View.GONE);
    }

    @Override
    public void hideTopMoviesLoading() {
        topMoviesProgressBar.setVisibility(View.GONE);
        topMoviesTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTopActionsLoading() {
        topActionsProgressBar.setVisibility(View.GONE);
        topActionsTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTopComediesLoading() {
        topComediesProgressBar.setVisibility(View.GONE);
        topComediesTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTopAnimationsLoading() {
        topAnimationsProgressBar.setVisibility(View.GONE);
        topAnimationsTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInTopMovies() {
        topMoviesNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInTopActions() {
        topActionsNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInTopComedies() {
        topComediesNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInTopAnimations() {
        topAnimationsNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishSwipeGestureAction() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showNotifyingMessage(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG).show();
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
