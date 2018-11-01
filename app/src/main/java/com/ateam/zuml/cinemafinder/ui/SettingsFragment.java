package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.ateam.zuml.cinemafinder.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);
        init();
    }

    private void init() {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (MainActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(R.string.settings), true);
            widgetTuning.setBottomNavigationVisibility(false);
        }
    }
}

