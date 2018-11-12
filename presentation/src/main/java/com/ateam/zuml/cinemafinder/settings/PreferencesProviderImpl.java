package com.ateam.zuml.cinemafinder.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

public final class PreferencesProviderImpl implements PreferencesProvider {

    private SharedPreferences sharedPreferences;

    public PreferencesProviderImpl(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public boolean adultModeAvailable() {
        return sharedPreferences.getBoolean("pref_adult", false);
    }
}
