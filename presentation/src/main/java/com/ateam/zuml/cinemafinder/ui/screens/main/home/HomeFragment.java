package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.BaseFragment;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.ui.common.collection.CollectionRowAdapter;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements HomeView, BackButtonListener {

    private CollectionRowAdapter nowPlayingAdapter;
    private CollectionRowAdapter upcomingAdapter;

    @BindView(R.id.rv_now_playing_row) RecyclerView nowPlayingRecyclerView;
    @BindView(R.id.rv_upcoming_row) RecyclerView upcomingRecyclerView;

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
        nowPlayingAdapter = new CollectionRowAdapter(presenter.getListPresenter(), imageLoader);
        upcomingAdapter = new CollectionRowAdapter(presenter.getListPresenter(), imageLoader);
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

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
