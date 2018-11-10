package com.ateam.zuml.cinemafinder.ui.screens.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.navigation.CustomNavigator;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.util.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;

public class MainContainerFragment extends MvpAppCompatFragment implements MainContainerView, BackButtonListener {

    private CustomNavigator navigator;

    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    @Named(Constants.CHILD_CONTAINER)
    @Inject
    NavigatorHolder navigatorHolder;

    @InjectPresenter MainContainerPresenter presenter;

    public static MainContainerFragment newInstance() {
        return new MainContainerFragment();
    }

    @ProvidePresenter
    MainContainerPresenter provideHomePresenter() {
        MainContainerPresenter presenter = new MainContainerPresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_container, container, false);

        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, view);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem ->
                onBottomNavigationClicked(menuItem.getItemId()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getChildFragmentManager().findFragmentById(R.id.child_container) == null) {
            onBottomNavigationClicked(bottomNavigationView.getSelectedItemId());
        }
    }

    private boolean onBottomNavigationClicked(int itemId) {
        switch (itemId) {
            case R.id.action_home:
                presenter.onHomeScreenSelected();
                return true;
            case R.id.action_favorites:
                presenter.onFavoritesScreenSelected();
                return true;
            case R.id.action_ratings:
                presenter.onRatingsScreenSelected();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(getNavigator());
    }

    @Override
    public void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    private Navigator getNavigator() {
        if (navigator == null) {
            navigator = new CustomNavigator(getActivity(), getChildFragmentManager(), R.id.child_container);
        }
        return navigator;
    }

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.child_container);
        if (fragment instanceof BackButtonListener && ((BackButtonListener) fragment).onBackPressed()) {
            return true;
        } else {
            presenter.onBackPressed();
            return true;
        }
    }
}
