package com.ateam.zuml.cinemafinder.di.application.modules;

import android.content.Context;

import com.ateam.zuml.cinemafinder.utils.SourceUtil;
import com.ateam.zuml.cinemafinder.utils.SourceUtilImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class SourceUtilModule {

    @Singleton
    @Provides
    SourceUtil provideSourceUtil(final Context context) {
        return new SourceUtilImpl(context);
    }
}
