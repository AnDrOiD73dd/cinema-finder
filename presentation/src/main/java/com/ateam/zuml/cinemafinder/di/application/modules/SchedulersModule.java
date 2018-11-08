package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import com.ateam.zuml.cinemafinder.util.SchedulersProviderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class SchedulersModule {

    @Singleton
    @Provides
    SchedulersProvider providerSchedulersProvider() {
        return new SchedulersProviderImpl();
    }
}
