package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.*;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.enums.RowCollection;
import com.ateam.zuml.cinemafinder.presentation.presenter.HomePresenter;
import com.ateam.zuml.cinemafinder.presentation.view.HomeView;

public class HomeFragment extends MvpAppCompatFragment implements HomeView, BackButtonListener {

    @InjectPresenter HomePresenter presenter;
    private FragmentManager mFragmentManager;

    @ProvidePresenter
    HomePresenter provideHomePresenter() {
        HomePresenter presenter = new HomePresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getFragmentManager();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trends, container, false);
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
            widgetTuning.setupToolbar(getResources().getString(R.string.home), false);
            widgetTuning.setSearchVisibility(true);
        }
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }

    @Override
    public void inflateRow(RowCollection collection) {
        mFragmentManager.beginTransaction()
                .add(R.id.trends_container, RowFragment.newInstance(collection))
                .commit();
    }
}
