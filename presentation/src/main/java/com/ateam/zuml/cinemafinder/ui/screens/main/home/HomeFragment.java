package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
import com.ateam.zuml.cinemafinder.ui.common.collection_row.CollectionRowAdapter;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements HomeView, BackButtonListener {

    private CollectionRowAdapter nowPlayingAdapter;
    private CollectionRowAdapter upcomingAdapter;

    @BindView(R.id.home_root) LinearLayout rootView;
    @BindView(R.id.tv_now_playing_row_name) TextView nowPlayingTitleView;
    @BindView(R.id.rv_now_playing_row) RecyclerView nowPlayingRecyclerView;
    @BindView(R.id.pb_now_playing_row) ProgressBar nowPlayingProgressBar;
    @BindView(R.id.tv_now_playing_row_no_results) TextView nowPlayingNoResultsView;
    @BindView(R.id.tv_upcoming_row_name) TextView upcomingTitleView;
    @BindView(R.id.rv_upcoming_row) RecyclerView upcomingRecyclerView;
    @BindView(R.id.pb_upcoming_row) ProgressBar upcomingProgressBar;
    @BindView(R.id.tv_upcoming_row_no_results) TextView upcomingNoResultsView;

    @Inject ImageLoader imageLoader;

    @InjectPresenter HomePresenter presenter;

    @ProvidePresenter
    HomePresenter provideHomePresenter() {
        HomePresenter presenter = new HomePresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        setupRecyclerView(nowPlayingRecyclerView, nowPlayingAdapter);
        setupRecyclerView(upcomingRecyclerView, upcomingAdapter);
        setupToolbar(R.string.app_name, false);
        return view;
    }

    private void init(View v) {
        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, v);
        nowPlayingAdapter = new CollectionRowAdapter(presenter.getNowPlayingPresenter(), imageLoader);
        upcomingAdapter = new CollectionRowAdapter(presenter.getUpcomingPresenter(), imageLoader);
    }

    private void setupRecyclerView(RecyclerView recyclerView, CollectionRowAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    // ######################################## HomeView #########################################

    @Override
    public void updateNowPlayingRow() {
        nowPlayingAdapter.refreshView();
    }

    @Override
    public void updateUpcomingRow() {
        upcomingAdapter.refreshView();
    }

    @Override
    public void showNowPlayingLoading() {
        nowPlayingProgressBar.setVisibility(View.VISIBLE);
        nowPlayingTitleView.setVisibility(View.GONE);
    }

    @Override
    public void hideNowPlayingLoading() {
        nowPlayingProgressBar.setVisibility(View.GONE);
        nowPlayingTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUpcomingLoading() {
        upcomingProgressBar.setVisibility(View.VISIBLE);
        upcomingTitleView.setVisibility(View.GONE);
    }

    @Override
    public void hideUpcomingLoading() {
        upcomingProgressBar.setVisibility(View.GONE);
        upcomingTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInNowPlaying() {
        nowPlayingNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInUpcoming() {
        upcomingNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        Snackbar.make(rootView, R.string.collection_row_error_message, Snackbar.LENGTH_LONG).show();
    }

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
