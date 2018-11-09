package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.AppActivity;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.ui.common.WidgetTuning;

public class RatingsFragment extends MvpAppCompatFragment implements RatingsView, BackButtonListener {

    @InjectPresenter RatingsPresenter presenter;

    public static RatingsFragment newInstance() {
        RatingsFragment fragment = new RatingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
        init();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    // #################################### BackButtonListener ####################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }

    private void init() {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (AppActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(R.string.ratings), false);
            widgetTuning.setSearchVisibility(true);
        }
    }
}
