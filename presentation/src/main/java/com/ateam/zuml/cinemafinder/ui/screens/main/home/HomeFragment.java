package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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
import com.ateam.zuml.cinemafinder.ui.common.collection.CollectionRowFragment;
import com.ateam.zuml.cinemafinder.util.CollectionsRow;

public class HomeFragment extends BaseFragment implements HomeView, BackButtonListener {

    private FragmentManager fragmentManager;

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
        setupToolbar(R.string.app_name, false);
        fragmentManager = getFragmentManager();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    // ######################################## HomeView #########################################

    @Override
    public void inflatePopularRow(CollectionsRow collection) {
        if (fragmentManager.findFragmentByTag(collection.name()) == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.popular_row_container, CollectionRowFragment.newInstance(collection), collection.name())
                    .commit();
        }
    }

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
