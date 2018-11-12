package com.ateam.zuml.cinemafinder.di.application.modules;

import android.content.Context;
import com.ateam.zuml.cinemafinder.settings.PreferencesProvider;
import com.ateam.zuml.cinemafinder.settings.PreferencesProviderImpl;
import dagger.Module;
import dagger.Provides;

@Module
public final class PreferencesModule {

    @Provides
    PreferencesProvider providePreferences(Context context) {
        return new PreferencesProviderImpl(context);
    }

}
