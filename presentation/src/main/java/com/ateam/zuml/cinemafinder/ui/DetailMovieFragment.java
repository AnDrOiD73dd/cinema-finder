package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.DetailMoviePresenter;
import com.ateam.zuml.cinemafinder.presentation.view.DetailMovieView;

public class DetailMovieFragment extends MvpAppCompatFragment implements DetailMovieView {

    @InjectPresenter DetailMoviePresenter presenter;

    public static DetailMovieFragment newInstance() {
        DetailMovieFragment fragment = new DetailMovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_movie, container, false);
        setupToolbar();
        return view;
    }

    private void setupToolbar() {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (MainActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(R.string.search_response), true);
            widgetTuning.setSearchVisibility(true);
        }
    }
}
