package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.SchedulersProvider;
import com.ateam.zuml.cinemafinder.util.SchedulersProviderImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface SchedulersModule {

    @Singleton
    @Binds
    SchedulersProvider provideSchedulersProvider(final SchedulersProviderImpl provider);
}
