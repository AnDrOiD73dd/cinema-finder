package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.HomePresenter;
import com.ateam.zuml.cinemafinder.presentation.view.HomeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class HomeFragment extends MvpAppCompatFragment implements HomeView {

    @Inject Router router;
    @Inject NavigatorHolder navigatorHolder;

    @InjectPresenter HomePresenter mMainPresenter;

    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    private Navigator navigator;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        App.getApp().getAppComponent().inject(this);

        ButterKnife.bind(this, view);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> showFragment(menuItem.getItemId()));

        return view;
    }

    private boolean showFragment(int itemId) {
        switch (itemId) {
            case R.id.action_trends:
                router.replaceScreen(new Screens.TrendsScreen());
                return true;
            case R.id.action_favorites:
                router.replaceScreen(new Screens.FavoritesScreen());
                return true;
            case R.id.action_ratings:
                router.replaceScreen(new Screens.RatingsScreen());
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(getNavigator());
        showFragment(bottomNavigationView.getSelectedItemId());
    }

    @Override
    public void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    private Navigator getNavigator() {
        if (navigator == null) {
            navigator = new SupportAppNavigator(getActivity(), getChildFragmentManager(), R.id.child_container);
        }
        return navigator;
    }
}
