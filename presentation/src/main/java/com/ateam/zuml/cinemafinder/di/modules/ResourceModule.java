package com.ateam.zuml.cinemafinder.di.modules;

import com.ateam.zuml.cinemafinder.util.ResourceManager;
import com.ateam.zuml.cinemafinder.util.ResourceManagerImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface ResourceModule {

    @Singleton
    @Binds
    ResourceManager provideResourceManager(final ResourceManagerImpl provider);
}
