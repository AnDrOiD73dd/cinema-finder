package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.*;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.enums.RowCollection;
import com.ateam.zuml.cinemafinder.ui.BaseFragment;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.ui.screens.main.home.collections.RowFragment;

public class HomeFragment extends BaseFragment implements HomeView, BackButtonListener {

    @InjectPresenter HomePresenter presenter;
    private FragmentManager mFragmentManager;

    @ProvidePresenter
    HomePresenter provideHomePresenter() {
        HomePresenter presenter = new HomePresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
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
        setupToolbar(R.string.app_name, false);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public void inflateRow(RowCollection collection) {
        mFragmentManager.beginTransaction()
                .add(R.id.trends_container, RowFragment.newInstance(collection))
                .commit();
    }

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
