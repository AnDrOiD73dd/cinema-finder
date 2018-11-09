package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.StringUtilImpl;
import com.ateam.zuml.cinemafinder.util.StringUtils;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface UtilsModule {

    @Singleton
    @Binds
    StringUtils provideStringUtil(final StringUtilImpl stringUtil);
}
