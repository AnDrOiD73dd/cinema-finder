package com.ateam.zuml.cinemafinder.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ateam.zuml.cinemafinder.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init(container.getContext());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void init(Context context) {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = ((WidgetTuning) context);
        widgetTuning.setupToolbar(getResources().getString(R.string.settings), true);
        widgetTuning.setSearchVisibility(false);
    }
}