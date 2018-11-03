package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.CiceroneHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NavigationModule {

    @Provides
    @Singleton
    CiceroneHolder provideNavigationHolder() {
        return new CiceroneHolder();
    }
}
