package com.ateam.zuml.cinemafinder.ui.screens.settings;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.AppActivity;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.ui.common.WidgetTuning;
import com.ateam.zuml.cinemafinder.util.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.AndroidSupportInjection;
import ru.terrakok.cicerone.Router;


public class SettingsFragment extends PreferenceFragmentCompat implements BackButtonListener {

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        init();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void init() {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (AppActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(R.string.settings), true);
            widgetTuning.setSearchVisibility(false);
        }
    }

    //region ### BackButtonListener ###
    @Override
    public boolean onBackPressed() {
        router.exit();
        return true;
    }
    //endregion
}