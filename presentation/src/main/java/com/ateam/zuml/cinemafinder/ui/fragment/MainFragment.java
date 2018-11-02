package com.ateam.zuml.cinemafinder.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.MainPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.MainFragmentView;
import com.ateam.zuml.cinemafinder.ui.FavoritesFragment;
import com.ateam.zuml.cinemafinder.ui.RatingsFragment;
import com.ateam.zuml.cinemafinder.ui.TrendsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends MvpAppCompatFragment implements MainFragmentView {

    public static final String TAG = "MainFragment";

    @InjectPresenter
    MainPresenter mMainPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private OnFragmentInteractionListener listener;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listener.setupToolbar(toolbar);
        setHasOptionsMenu(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                fragmentManager.popBackStack();
                return true;
            case R.id.action_settings:
                listener.onOpenSettingsClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void replaceChildFragment(Fragment fragment, String fragmentTag) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.child_container, fragment, fragmentTag)
                .commit();
    }

    public interface OnFragmentInteractionListener {

        void setupToolbar(Toolbar toolbar);

        void onOpenSettingsClick();
    }
}
