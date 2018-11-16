package com.ateam.zuml.cinemafinder.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.ateam.zuml.cinemafinder.R;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class PreferenceUtilsImpl implements PreferenceUtils {

    private final SharedPreferences sharedPreferences;

    private final String isAdultSaveKey;

    @Inject
    PreferenceUtilsImpl(final Context context) {
        isAdultSaveKey = context.getResources().getString(R.string.is_adult_save_key);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public boolean isAdultContentActive() {
        return sharedPreferences.getBoolean(isAdultSaveKey, false);
    }
}
