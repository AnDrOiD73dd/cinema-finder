package com.ateam.zuml.cinemafinder.ui;

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
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.FavoritesPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.FavoritesView;

public class FavoritesFragment extends MvpAppCompatFragment implements FavoritesView {

    @InjectPresenter FavoritesPresenter favoritesPresenter;

    public static FavoritesFragment newInstance() {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        init();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    private void init() {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (MainActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(R.string.favorites), false);
        }
    }
}
