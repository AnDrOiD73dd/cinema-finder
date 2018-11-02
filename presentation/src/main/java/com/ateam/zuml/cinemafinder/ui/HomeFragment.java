package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.HomePresenter;
import com.ateam.zuml.cinemafinder.presentation.view.HomeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends MvpAppCompatFragment implements HomeView {

    public static final String TAG = "HomeFragment";

    @InjectPresenter HomePresenter mMainPresenter;

    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    private FragmentManager fragmentManager;

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
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentManager = getChildFragmentManager();
        if (fragmentManager.findFragmentByTag(TrendsFragment.TAG) == null) {
            replaceChildFragment(TrendsFragment.newInstance(), TrendsFragment.TAG);
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.action_trends:
                    replaceChildFragment(TrendsFragment.newInstance(), TrendsFragment.TAG);
                    return true;
                case R.id.action_favorites:
                    replaceChildFragment(FavoritesFragment.newInstance(), FavoritesFragment.TAG);
                    return true;
                case R.id.action_ratings:
                    replaceChildFragment(RatingsFragment.newInstance(), RatingsFragment.TAG);
                    return true;
                default:
                    return false;
            }
        });
    }

    private void replaceChildFragment(Fragment fragment, String fragmentTag) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.child_container, fragment, fragmentTag)
                .commit();
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
            widgetTuning.setupToolbar(getResources().getString(R.string.app_name), false);
        }
    }
}
